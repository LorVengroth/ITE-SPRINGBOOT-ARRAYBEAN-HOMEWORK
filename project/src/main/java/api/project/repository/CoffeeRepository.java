package api.project.repository;

import api.project.domain.Coffee;
import api.project.dto.CoffeeResponse;
import api.project.dto.CreateCoffeeRequest;
import api.project.dto.UpdateCoffeeRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;


@Repository
public class CoffeeRepository {

    public final List<CoffeeResponse> coffeeList = new ArrayList<>();

    public CoffeeRepository() {
        Coffee coffee1 = new Coffee(1 , "hot late", "jganh nas" , 1.5);
        Coffee coffee2 = new Coffee(2 , "ice late", "jganh nas" , 1.5);
        Coffee coffee3 = new Coffee(3 , "coffee late", "jganh nas" , 1.5);

        CoffeeResponse coffeeResponse1 = mapToResponse(coffee1);
        CoffeeResponse coffeeResponse2 = mapToResponse(coffee2);
        CoffeeResponse coffeeResponse3 = mapToResponse(coffee3);


        coffeeList.add(coffeeResponse1);
        coffeeList.add(coffeeResponse2);
        coffeeList.add(coffeeResponse3);
    }

    public final List<CoffeeResponse> beanCoffee() {
        return coffeeList ;
    }

    public CoffeeResponse findById(int id) {

        return beanCoffee()
                .stream()
                .filter(coffee -> coffee.getId() == id)
                .findFirst()
                .orElseThrow(()-> new RuntimeException("cofee not found with id :" +id) );
    }

    public List<CoffeeResponse> findByName(String name) {

        return coffeeList
                .stream()
                .filter(coffee -> coffee.getName().equalsIgnoreCase(name))
                .toList()
                ;
    }

    public List<CoffeeResponse> searchByNameAndPrice(String name, Double price) {

        return coffeeList
                .stream()
                .filter(coffee ->
                        coffee.getName().toLowerCase().contains(name.toLowerCase())
                        || coffee.getPrice().equals(price)
                )
                .toList();
    }

    public CoffeeResponse CreateCoffee(CreateCoffeeRequest createCoffeeRequest){
        Coffee coffee = new Coffee();
        coffee.setId(new Random().nextInt(100)); // create random id
        coffee.setName(createCoffeeRequest.getName());
        coffee.setPrice(createCoffeeRequest.getPrice());
        coffee.setDescription(createCoffeeRequest.getDescription());

        CoffeeResponse coffeeResponse = mapToResponse(coffee);

        Boolean isExist = coffeeList.stream().anyMatch(c -> c.getId().equals(coffee.getId()));
        if (isExist) throw new RuntimeException("ID already exist");
        coffeeList.add(coffeeResponse);
        return mapToResponse(coffee);

    }

    private CoffeeResponse mapToResponse(Coffee coffee) {

        CoffeeResponse response = new CoffeeResponse();

        response.setId(coffee.getId());
        response.setName(coffee.getName());
        response.setDescription(coffee.getDescription());
        response.setPrice(coffee.getPrice());

        return response;
    }

    public CoffeeResponse UpdateCoffeeById(UpdateCoffeeRequest updateCoffeeRequest , Integer id){
        return coffeeList
                .stream()
                .filter( coffee -> coffee.getId().equals(id))
                .findFirst()
                .map( oldcoffee -> {
                    oldcoffee.setName(updateCoffeeRequest.getName());
                    oldcoffee.setDescription(updateCoffeeRequest.getDescription());
                    oldcoffee.setPrice(updateCoffeeRequest.getPrice());

                    return  oldcoffee ;
                        }

                )
                .orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND , String.format("Coffee with id %d not found" , id)));


    }

    public CoffeeResponse deleteCoffeeById(Integer id){
        CoffeeResponse coffeeToDelete = coffeeList.stream()
                .filter(coffee -> coffee.getId().equals(id))
                .findFirst()
                .orElseThrow(() -> new ResponseStatusException(
                        HttpStatus.NOT_FOUND,
                        String.format("Coffee with id %d not found and cannot be deleted", id)
                ));


        coffeeList.remove(coffeeToDelete);

        return coffeeToDelete;

    }


}
