package api.project.service;


import api.project.domain.Coffee;
import api.project.dto.CoffeeResponse;

import java.util.List;


public interface CoffeeService {
    List<Coffee> getCoffees();
    CoffeeResponse getCoffeeById(Integer id);
    List<CoffeeResponse > getCoffeeByNameAndPrice(String name , Double price);
}
