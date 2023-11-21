package itmo.csa.nosqlexample.controllers;


import itmo.csa.nosqlexample.exceptions.NotFoundException;
import itmo.csa.nosqlexample.models.ContactDto;
import itmo.csa.nosqlexample.services.ContactsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@org.springframework.web.bind.annotation.RestController
@RequestMapping("/api/")
public class RestController {
    @Autowired
    private ContactsService service;
    @GetMapping("contacts/{type}")
    ResponseEntity<?> getContact(@PathVariable String type) {
        boolean secured = type.equals("v2");
        if (!type.equals("v1") && !type.equals("v2"))
            throw new NotFoundException();
        List<ContactDto> contactDtoList = service.getContacts(secured);
        if (contactDtoList == null)
            throw new RuntimeException();
        return ResponseEntity.ok(contactDtoList);
    }

}
