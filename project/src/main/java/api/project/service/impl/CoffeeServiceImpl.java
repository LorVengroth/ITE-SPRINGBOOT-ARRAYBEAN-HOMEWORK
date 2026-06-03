package api.project.service.impl;

import api.project.domain.Coffee;
import api.project.dto.CoffeeResponse;
import api.project.dto.CreateCoffeeRequest;
import api.project.dto.UpdateCoffeeRequest;
import api.project.repository.CoffeeRepository;
import api.project.service.CoffeeService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class CoffeeServiceImpl implements CoffeeService {

    private final CoffeeRepository coffeeRepository ;


    public CoffeeServiceImpl(CoffeeRepository coffeeRepository){
        this.coffeeRepository = coffeeRepository ;
    }

    @Override
    public List<CoffeeResponse> getCoffees() {
        return coffeeRepository.beanCoffee();
    }


    @Override
    public CoffeeResponse getCoffeeById(Integer id){


    return coffeeRepository.findById(id);

    }

    @Override
    public List<CoffeeResponse> getCoffeeByNameAndPrice(String name, Double price) {
        return coffeeRepository.searchByNameAndPrice(name , price);
    }

    @Override
    public CoffeeResponse createCoffee(CreateCoffeeRequest createCoffeeRequest) {
        return coffeeRepository.CreateCoffee(createCoffeeRequest);
    }


    @Override
    public CoffeeResponse updateCoffeeByID(UpdateCoffeeRequest updateCoffeeRequest , Integer id) {
        return coffeeRepository.UpdateCoffeeById(updateCoffeeRequest , id);
    }

    @Override
    public CoffeeResponse deleteCoffeeById(Integer id) {
        return coffeeRepository.deleteCoffeeById(id);
    }
}
