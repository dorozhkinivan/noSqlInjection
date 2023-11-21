package itmo.csa.nosqlexample.services;

import itmo.csa.nosqlexample.models.ContactDto;
import itmo.csa.nosqlexample.repos.UnsecureRepo;
import itmo.csa.nosqlexample.repos.SecureRepo;
import itmo.csa.nosqlexample.utils.ContactConverter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ContactsServiceImpl implements ContactsService {
    @Autowired
    private SecureRepo secureRepo;

    @Autowired
    private UnsecureRepo unsecureRepo;

    @Autowired
    private ContactConverter converter;

    @Override
    public List<ContactDto> getContacts(boolean secured) {
        if (secured)
            return secureRepo.findAll().stream().map(converter::convert).toList();
        return unsecureRepo.getContacts();
    }

}
