package employee.controller.dto;

import java.util.Date;
import java.util.UUID;

/**
 * Created by idimaster on 5/18/17.
 */
public class EmployeeUpdate {
    private UUID id;
    private UUID employeeId;
    private Date effective;
    private Address address;
    private String phone;

    public EmployeeUpdate() {
    }

    public EmployeeUpdate(UUID id, UUID employeeId, Date effective) {
        this.id = id;
        this.employeeId = employeeId;
        this.effective = effective;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }

    public UUID getEmployeeId() {
        return employeeId;
    }

    public void setEmployeeId(UUID employeeId) {
        this.employeeId = employeeId;
    }

    public Date getEffective() {
        return effective;
    }

    public void setEffective(Date effective) {
        this.effective = effective;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }
}
