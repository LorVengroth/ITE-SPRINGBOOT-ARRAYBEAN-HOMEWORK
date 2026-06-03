package api.project.exp;

import lombok.Builder;

@Builder
public record FieldErrorResponse (
        String field ,
        Integer code ,
        String message

){
}
