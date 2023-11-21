package itmo.csa.nosqlexample.services;

import itmo.csa.nosqlexample.models.ContactDto;

import java.util.List;

public interface ContactsService {
    List<ContactDto> getContacts(boolean secured);
}
