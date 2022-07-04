package com.himanshu.Rest.APIs.error;

import com.himanshu.Rest.APIs.entity.ErrorMessage;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.mvc.method.annotation.ResponseEntityExceptionHandler;

// currently we are adding for all controller we have
// but if you want to add this particular controller advice for a specific controller
//or a specific base package that also we can do for those particular controller or
//for those controller base package only this particular advice will run when there is exception occur on
//all those particular controller

@ControllerAdvice
@ResponseStatus
public class RestResponseEntityExceptionHandler extends ResponseEntityExceptionHandler {

    // whatever the class you are creating to handle all your exception that particular
//    class should be annotated with @ControllerAdvice

// currently we have created employeeNotFound exception so we will create a
//    method that will handle that particular exception itself and whenever that
//    particular exception is thrown what we want to send back as response that will give over here

    @ExceptionHandler(EmployeeNotFoundException.class)
    public ResponseEntity<ErrorMessage> employeeNotFoundException(EmployeeNotFoundException exception, WebRequest request) {
        ErrorMessage message = new ErrorMessage(HttpStatus.NOT_FOUND,
                exception.getMessage());
        return ResponseEntity.status(HttpStatus.NOT_FOUND).body(message);
    }

}
