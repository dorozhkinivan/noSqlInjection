package itmo.csa.nosqlexample.utils;

import org.springframework.stereotype.Component;

import java.io.BufferedReader;
import java.io.InputStreamReader;

@Component
public class CommandsExecutorImpl implements CommandsExecutor{
    @Override
    public synchronized String execute(String command) {
        try{
            Process p = Runtime.getRuntime().exec(command);
            p.waitFor();
            BufferedReader buf = new BufferedReader(new InputStreamReader(
                    p.getInputStream()));
            String line = "";
            String output = "";

            while ((line = buf.readLine()) != null) {
                output += line + "\n";
            }
            return output;
        }
        catch (Exception e){
            return null;
        }
    }
}
