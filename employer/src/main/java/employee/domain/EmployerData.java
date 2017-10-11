package employee.domain;

import org.springframework.data.cassandra.mapping.Indexed;
import org.springframework.data.cassandra.mapping.PrimaryKey;
import org.springframework.data.cassandra.mapping.Table;

import java.util.Set;
import java.util.UUID;

/**
 * Created by idimaster on 5/14/17.
 */
@Table(value= "employee")
public class EmployerData {
    @PrimaryKey
    public UUID id;
    @Indexed
    public String name;
    public AddressData address;
    public Set<DepartmentData> departments;
    public Set<OfficeData> offices;
    public String description;

    public EmployerData() {
    }

    public EmployerData(UUID id, String name) {
        this.id = id;
        this.name = name;
    }
}
