package api.project.repository;

import api.project.domain.Coffee;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Repository;

import java.util.Arrays;
import java.util.List;

@Repository
public class CoffeeRepository {

    @Bean
    public List<Coffee> beanCoffee(){
        Coffee coffee1 = new Coffee(1 , "Ice Late1" , "Jganh Klang nas");
        Coffee coffee2 = new Coffee(2 , "Ice Late2" , "Jganh dol kor");
        Coffee coffee3 = new Coffee(3 , "Ice Late3" , "jg nham tt");
        return Arrays.asList(coffee1 , coffee2 , coffee3);

    }

}
