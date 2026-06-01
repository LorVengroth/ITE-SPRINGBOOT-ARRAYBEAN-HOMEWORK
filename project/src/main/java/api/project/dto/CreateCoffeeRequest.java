package api.project.dto;


import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Positive;
import jakarta.validation.constraints.Size;
import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class CreateCoffeeRequest {

    @NotBlank(message = "name is required")
    @Size(min = 3 , max = 256)
    private String name ;
    @NotBlank(message = "description is required")
    @Size(min = 3 , max = 10000)
    private String description ;
    @NotNull
    @Positive
    private Double price ;


}
