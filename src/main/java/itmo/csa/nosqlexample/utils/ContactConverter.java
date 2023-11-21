package itmo.csa.nosqlexample.utils;

import itmo.csa.nosqlexample.models.ContactDocument;
import itmo.csa.nosqlexample.models.ContactDto;
import org.springframework.stereotype.Component;

@Component
public class ContactConverter {
    public ContactDto convert(ContactDocument document){
        return new ContactDto(document.getName(), document.getLinks());
    }
}
