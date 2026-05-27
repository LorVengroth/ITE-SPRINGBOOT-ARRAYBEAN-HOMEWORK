package api.project.controller;


import api.project.domain.Coffee;
import api.project.service.CoffeeService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coffees")
public class CoffeeController {

    private final CoffeeService coffeeService ;

    public CoffeeController(CoffeeService coffeeService){
        this.coffeeService = coffeeService ;
    }

    @GetMapping
    public List<Coffee> getCoffees(){
        return coffeeService.getCoffees();
    }


}
