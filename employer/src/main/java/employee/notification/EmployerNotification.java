package employee.notification;

import com.datastax.driver.core.utils.UUIDs;
import employee.controller.dto.Employer;
import employee.notification.messages.CommandType;
import employee.notification.messages.EmployerCommand;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

/**
 * Created by idimaster on 5/18/17.
 */
public class EmployerNotification {
    private static final String TOPIC = "EmployerNotification";

    @Autowired
    private KafkaTemplate<String, EmployerCommand> template;

    public void add(Employer data) {
        send(CommandType.Add, data);
    }

    public void update(Employer data) {
        send(CommandType.Update, data);
    }

    public void delete(Employer data) {
        send(CommandType.Delete, data);
    }

    private void send(CommandType command, Employer data) {
        EmployerCommand message = new EmployerCommand();
        message.setBody(data);
        message.setId(UUIDs.timeBased());
        message.setCommand(command);
        template.send(TOPIC, message.getId().toString() ,message);
    }
}
