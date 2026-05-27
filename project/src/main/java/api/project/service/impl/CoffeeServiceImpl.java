package api.project.service.impl;

import api.project.domain.Coffee;
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
    public List<Coffee> getCoffees() {
        return coffeeRepository.beanCoffee();
    }
}
