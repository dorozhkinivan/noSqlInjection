package itmo.csa.nosqlexample.repos;

import itmo.csa.nosqlexample.models.ContactDocument;
import org.springframework.data.mongodb.repository.MongoRepository;

import java.math.BigInteger;
import java.util.List;


public interface SecureRepo extends MongoRepository<ContactDocument, BigInteger> {


    List<ContactDocument> findByName(String name);


}
