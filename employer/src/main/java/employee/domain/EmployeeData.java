package employee.domain;

import org.springframework.data.cassandra.mapping.Indexed;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Date;
import java.util.UUID;

/**
 * Created by idimaster on 5/18/17.
 */
@Table(value="employee")
public class EmployeeData {
    @PrimaryKey
    public UUID id;
    @Indexed
    public UUID employerId;
    public NameInfoData name;
    @Indexed
    public String email;
    public String department;
    public String office;
    public AddressData address;
    public String ssn;
    public String phone;
    public Date dob;
    public String gender;
    public String maritalStatus;
    public Integer annualPay;

    public EmployeeData() {
    }

    public EmployeeData(UUID id, UUID employerId, String email) {

        this.id = id;
        this.employerId = employerId;
        this.email = email;
    }
}
