package com.example.checkout.common;


import com.example.checkout.exception.CheckoutValidationException;
import com.example.checkout.exception.PaymentIntegrationException;
import com.example.checkout.integration.PaymentIntegrationManager;
import com.example.checkout.model.ExceptionResponse;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

@ControllerAdvice
public class ApiControllerExceptionHandler {


    @ExceptionHandler(value = Exception.class)
    public ResponseEntity<Object> genericException(Exception exception) {
        return buildResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);
    }

    @ExceptionHandler(value = CheckoutValidationException.class)
    public ResponseEntity<Object> genericException(CheckoutValidationException exception) {
        return buildResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    @ExceptionHandler(value = PaymentIntegrationException.class)
    public ResponseEntity<Object> genericException(PaymentIntegrationException exception) {
        return buildResponseEntity(exception, HttpStatus.INTERNAL_SERVER_ERROR);

    }
    private ResponseEntity<Object> buildResponseEntity(Throwable exception, HttpStatus httpStatus) {
        ExceptionResponse errorResponse = new  ExceptionResponse (exception.getMessage(),httpStatus.name(),httpStatus.toString());
        return new ResponseEntity<>(errorResponse, httpStatus);
    }
}
