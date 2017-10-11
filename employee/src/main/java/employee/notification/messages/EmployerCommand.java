package employee.notification.messages;

import employee.controller.dto.Employer;

import java.util.UUID;

/**
 * Created by idimaster on 5/18/17.
 */
public class EmployerCommand {
    private CommandType command;
    private UUID id;
    private Employer body;

    public CommandType getCommand() {
        return command;
    }

    public void setCommand(CommandType command) {
        this.command = command;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public Employer getBody() {
        return body;
    }

    public void setBody(Employer body) {
        this.body = body;
    }
}
