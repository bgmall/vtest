package jackson;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;

import java.io.IOException;
import java.io.StringWriter;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Created by msg on 2017/3/16.
 */
public class JacksonMain {

    public static void main(String[] args) throws IOException {
        AtomicInteger atomicInteger = new AtomicInteger(1);
        ObjectMapper objectMapper = new ObjectMapper();
       // String jsonString = objectMapper.writeValueAsString(atomicInteger);
        StringWriter stringWriter = new StringWriter();
        objectMapper.writeValue(stringWriter, atomicInteger);
        String jsonString = stringWriter.toString();
        System.out.println(jsonString);
        AtomicInteger atomicInteger1 = objectMapper.readValue(jsonString, AtomicInteger.class);
        System.out.println(atomicInteger1);

        SimpleClass simpleClass = new SimpleClass();
        simpleClass.setValue(10);
        simpleClass.getInteger().set(1);
        String jsonString1 = objectMapper.writeValueAsString(simpleClass);
        System.out.println(jsonString1);
        SimpleClass simpleClass1 = objectMapper.readValue(jsonString1, SimpleClass.class);
        System.out.println(simpleClass1);
    }
}
