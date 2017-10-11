package employee.controller.dto;

import java.util.Date;
import java.util.UUID;

/**
 * Created by idimaster on 5/18/17.
 */
public class Employee {
    private UUID id;
    private UUID employerId;
    private NameInfo name;
    private String email;
    private String department;
    private String office;
    private Address address;
    private String ssn;
    private String phone;
    private Date dob;
    private String gender;
    private String maritalStatus;
    private Integer annualPay;

    public Employee() {
    }

    public Employee(UUID id, UUID employerId, String email) {
        this.id = id;
        this.employerId = employerId;
        this.email = email;
    }

    public Integer getAnnualPay() {
        return annualPay;
    }

    public void setAnnualPay(Integer annualPay) {
        this.annualPay = annualPay;
    }

    public UUID getEmployerId() {
        return employerId;
    }

    public void setEmployerId(UUID employerId) {
        this.employerId = employerId;
    }

    public NameInfo getName() {
        return name;
    }

    public void setName(NameInfo name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getDepartment() {
        return department;
    }

    public void setDepartment(String department) {
        this.department = department;
    }

    public String getOffice() {
        return office;
    }

    public void setOffice(String office) {
        this.office = office;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }

    public String getSsn() {
        return ssn;
    }

    public void setSsn(String ssn) {
        this.ssn = ssn;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public Date getDob() {
        return dob;
    }

    public void setDob(Date dob) {
        this.dob = dob;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public String getMaritalStatus() {
        return maritalStatus;
    }

    public void setMaritalStatus(String maritalStatus) {
        this.maritalStatus = maritalStatus;
    }

    public UUID getId() {
        return id;
    }

    public void setId(UUID id) {
        this.id = id;
    }
}
