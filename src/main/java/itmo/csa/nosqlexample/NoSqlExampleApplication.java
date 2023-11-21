package itmo.csa.nosqlexample;

import itmo.csa.nosqlexample.models.ContactDto;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@SpringBootApplication
public class NoSqlExampleApplication {

    public static void main(String[] args) throws Exception{
        SpringApplication.run(NoSqlExampleApplication.class, args);
    }

}
