package api.project.exp;

import lombok.Builder;

@Builder
public record ErrorResponse<T>(
        Boolean status ,
        Integer code ,
        String message ,
        T error

) {
}
