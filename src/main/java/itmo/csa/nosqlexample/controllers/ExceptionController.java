package itmo.csa.nosqlexample.controllers;

import itmo.csa.nosqlexample.exceptions.NotFoundException;
import itmo.csa.nosqlexample.models.ContactDto;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ExceptionController {
    @ExceptionHandler(NotFoundException.class)
    ResponseEntity<?> getContact() {
        return ResponseEntity.status(404).build();
    }
}
