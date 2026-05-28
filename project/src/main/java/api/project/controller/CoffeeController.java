package api.project.controller;


import api.project.domain.Coffee;
import api.project.dto.CoffeeResponse;
import api.project.service.CoffeeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/v1/coffees")
@Slf4j
public class CoffeeController {

    private final CoffeeService coffeeService ;

    public CoffeeController(CoffeeService coffeeService){
        this.coffeeService = coffeeService ;
    }

    @GetMapping
    public List<Coffee> getCoffees(){
        return coffeeService.getCoffees();
    }


    @GetMapping("/{id}")
    public CoffeeResponse getCoffeeById(@PathVariable Integer id){
        log.info("GET id: {}" , id);
        return coffeeService.getCoffeeById(id) ;
    }

    // this call request param
    // to search localhost:8081/api/v1/coffees/search?name=late&id=1

    @GetMapping("/search")
    public List<CoffeeResponse> searchCoffeeByNameAndPrice(
            @RequestParam String name,
            @RequestParam Double price
    ){
        log.info("GET name: {}" , name);
        log.info("GET ID: {}" , price);
        return coffeeService.getCoffeeByNameAndPrice(name , price) ;
    }



}
