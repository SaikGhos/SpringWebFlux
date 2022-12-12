package Assignment2.UpdatesService.Constant;

import org.springframework.stereotype.Component;

@Component
public  class KafkaConstants {

    public static final String TOPIC1="appUpdates";
    public static final String TOPIC2="employeeUpdates";
    public static final String TOPIC3="employeeDLQ";
    public static final String GROUP_ID="group-employees";
    public static final String HOST="localhost:9092";
}
