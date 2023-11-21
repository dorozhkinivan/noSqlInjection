package itmo.csa.nosqlexample.repos;

import itmo.csa.nosqlexample.models.ContactDto;

import java.util.List;

public interface UnsecureRepo {
    List<ContactDto> getContacts();

}
