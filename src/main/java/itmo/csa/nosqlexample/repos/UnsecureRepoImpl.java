package itmo.csa.nosqlexample.repos;

import com.fasterxml.jackson.core.type.TypeReference;
import com.fasterxml.jackson.databind.ObjectMapper;
import itmo.csa.nosqlexample.models.ContactDto;
import itmo.csa.nosqlexample.utils.CommandsExecutor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public class UnsecureRepoImpl implements UnsecureRepo {
    private ObjectMapper mapper = new ObjectMapper();
    @Autowired
    private CommandsExecutor commandsExecutor;
    @Override
    public List<ContactDto> getContacts() {
        String answer = commandsExecutor.execute("mongosh --quiet testdb --eval 'db.myCollection5.find()'");
        if (answer == null)
            return null;
        try {
            return mapper.readValue(answer.replaceAll("_id: ObjectId\\(\"[a-zA-Z0-9]+\"\\),", "").replaceAll("'", "\"").replaceAll("name", "\"name\"").replaceAll("links", "\"links\""),  new TypeReference<List<ContactDto>>(){});
        }catch (Exception e){
            return List.of();
        }

    }
}
