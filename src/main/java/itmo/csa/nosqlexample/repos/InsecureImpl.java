package itmo.csa.nosqlexample.repos;

import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;
import org.springframework.data.mongodb.core.mapping.Field;

@Document("contacts")
public class InsecureImpl {
    @Id
    private String id;

    @Field("name")
    private String name;
}
