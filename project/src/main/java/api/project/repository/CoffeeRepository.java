package api.project.repository;

import api.project.domain.Coffee;
import api.project.dto.CoffeeResponse;
import api.project.dto.CreateCoffeeRequest;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.random.RandomGenerator;

@Repository
public class CoffeeRepository {

    public final List<CoffeeResponse> coffeeList = new ArrayList<>();

    public CoffeeRepository() {
        Coffee coffee1 = new Coffee(1 , "hot late", "jganh nas" , 1.5);
        Coffee coffee2 = new Coffee(1 , "ice late", "jganh nas" , 1.5);
        Coffee coffee3 = new Coffee(1 , "coffee late", "jganh nas" , 1.5);

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
}
