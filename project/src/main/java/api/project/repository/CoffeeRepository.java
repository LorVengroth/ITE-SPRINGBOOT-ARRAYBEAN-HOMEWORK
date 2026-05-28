package api.project.repository;

import api.project.domain.Coffee;
import api.project.dto.CoffeeResponse;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CoffeeRepository {


    public List<Coffee> beanCoffee(){
        Coffee coffee1 = new Coffee(1 , "icelate1" , "Jganh Klang nas" , 1.1);
        Coffee coffee2 = new Coffee(2 , "icelate2" , "Jganh dol kor", 1.2);
        Coffee coffee3 = new Coffee(3 , "icelate3" , "jg nham tt" , 1.3);
        return Arrays.asList(coffee1 , coffee2 , coffee3);

    }




}
