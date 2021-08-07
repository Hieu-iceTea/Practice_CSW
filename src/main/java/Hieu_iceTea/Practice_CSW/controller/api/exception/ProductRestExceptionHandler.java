package Hieu_iceTea.Practice_CSW.controller.api.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ProductRestExceptionHandler {

    //Add an exception handler for ProductNotFoundException
    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handlerException(ProductNotFoundException productNotFoundException) {

        //Create ProductErrorResponse
        ProductErrorResponse productErrorResponse = new ProductErrorResponse(
                HttpStatus.NOT_FOUND.value(),
                productNotFoundException.getMessage(),
                System.currentTimeMillis()
        );

        // return ResponseEntity
        return new ResponseEntity<>(productErrorResponse, HttpStatus.NOT_FOUND);

    }

    // Add another exception handler ... to catch any exception (catch all)
    @ExceptionHandler
    public ResponseEntity<ProductErrorResponse> handlerException(Exception exception) {

        //Create ProductErrorResponse
        ProductErrorResponse productErrorResponse = new ProductErrorResponse(
                HttpStatus.BAD_REQUEST.value(),
                exception.getMessage(),
                System.currentTimeMillis()
        );

        // return ResponseEntity
        return new ResponseEntity<>(productErrorResponse, HttpStatus.BAD_REQUEST);

    }

}
