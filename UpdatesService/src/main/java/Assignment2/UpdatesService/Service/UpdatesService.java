package Assignment2.UpdatesService.Service;
import Assignment2.UpdatesService.Constant.KafkaConstants;
import Assignment2.UpdatesService.Entity.EmpRequest;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Component;

@Component
@Slf4j
public class UpdatesService {
    @Autowired
    private KafkaTemplate kafkaTemplate;

    @KafkaListener(topics = KafkaConstants.TOPIC1,groupId = KafkaConstants.GROUP_ID)
    public void consume(EmpRequest employeeRequest){
        log.info("The message is consumed from the topic "+ KafkaConstants.TOPIC1);

        if (employeeRequest.getEmp_name()==null || employeeRequest.getEmp_city()==null || employeeRequest.getEmp_phone()==null){
            log.info("The message is produced to the topic "+ KafkaConstants.TOPIC3);
            kafkaTemplate.send(KafkaConstants.TOPIC3,employeeRequest);

        }
        else{
            log.info("The message is produced to the topic "+ KafkaConstants.TOPIC2);
            kafkaTemplate.send(KafkaConstants.TOPIC2,employeeRequest);

        }

    }




}
