package com.Student.GlobalException;

import java.time.LocalDateTime;
import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;

import com.Student.Exception.StudentNotFoundException;

@ControllerAdvice
public class GlobalExceptionHandler {

@ExceptionHandler( StudentNotFoundException.class)
private ResponseEntity<?> StudentNotFoundHandler(StudentNotFoundException except){
    return responsebody(HttpStatus.NOT_FOUND,except.getMessage());

}

private ResponseEntity<?> responsebody(HttpStatus statusquote,String message){

    Map<String,Object>  map = new LinkedHashMap<>();
    map.put("Status",statusquote.value());
    map.put("Error Message",message);
    map.put("Time",LocalDateTime.now());
    return new ResponseEntity<>(map,statusquote);
}

}
