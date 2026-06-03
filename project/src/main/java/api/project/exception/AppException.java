//package api.project.exception;
//
//
//import lombok.extern.slf4j.Slf4j;
//import org.springframework.http.ResponseEntity;
//import org.springframework.web.bind.MethodArgumentNotValidException;
//import org.springframework.web.bind.annotation.ExceptionHandler;
//import org.springframework.web.bind.annotation.RestControllerAdvice;
//
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//
//@RestControllerAdvice
//@Slf4j
//public class AppException {
//
//    @ExceptionHandler(MethodArgumentNotValidException.class)
//    public ResponseEntity<ApiResponse<List<ValidationError>>> handleValidationException(
//            MethodArgumentNotValidException ex) {
//
//        List<ValidationError> errors = ex.getBindingResult()
//                .getFieldErrors()
//                .stream()
//                .map(error -> new ValidationError(
//                        error.getField(),
//                        error.getDefaultMessage()
//                ))
//                .toList();
//
//        ApiResponse<List<ValidationError>> response =
//                new ApiResponse<>(
//                        false,
//                        400,
//                        "Validation failed",
//                        errors
//                );
//
//        return ResponseEntity.badRequest().body(response);
//    }
//}
