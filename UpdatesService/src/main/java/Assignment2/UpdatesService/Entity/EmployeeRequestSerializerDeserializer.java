package Assignment2.UpdatesService.Entity;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.fasterxml.jackson.databind.json.JsonMapper;
import org.apache.kafka.common.errors.SerializationException;
import org.apache.kafka.common.serialization.Deserializer;
import org.apache.kafka.common.serialization.Serializer;

import java.io.IOException;
import java.util.Map;

public class EmployeeRequestSerializerDeserializer implements Serializer<EmpRequest>, Deserializer<EmpRequest> {
    public static final ObjectMapper mapper = JsonMapper.builder()
            .findAndAddModules()
            .build();

    @Override
    public void configure(Map<String, ?> configs, boolean isKey) {
        Serializer.super.configure(configs, isKey);
    }

    @Override
    public byte[] serialize(String topic, EmpRequest employeeRequest) {
        try {
            return mapper.writeValueAsBytes(employeeRequest);
        } catch (JsonProcessingException e) {
            throw new SerializationException(e);
        }

    }

    @Override
    public EmpRequest deserialize(String topic, byte[] data) {
        try {
            return mapper.readValue(data, EmpRequest.class);
        } catch (IOException e) {
            throw new SerializationException(e);
        }
    }


    @Override
    public void close() {
        Serializer.super.close();
    }
}

