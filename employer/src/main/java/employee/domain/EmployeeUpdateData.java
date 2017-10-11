package employee.domain;

import org.springframework.data.cassandra.mapping.Indexed;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;
import java.util.UUID;

/**
 * Created by idimaster on 5/18/17.
 */
@Table(value="employeeUpdate")
public class EmployeeUpdateData {
    @PrimaryKey
    public UUID id;
    @Indexed
    public UUID employeeId;
    public Date effective;
    public AddressData address;
    public String phone;

    public EmployeeUpdateData() {
    }

    public EmployeeUpdateData(UUID id, UUID employeeId, Date effective) {
        this.id = id;
        this.employeeId = employeeId;
        this.effective = effective;
    }
}
