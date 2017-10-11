package employee.controller.mapping;

import employee.controller.dto.Employee;
import employee.domain.EmployeeData;

import java.util.Optional;

/**
 * Created by idimaster on 5/18/17.
 */
public class EmployeeMapping {
    public static Employee toDto(EmployeeData data) {
        Employee dto = new Employee(data.id, data.employerId, data.email);
        dto.setAnnualPay(data.annualPay);
        dto.setDepartment(data.department);
        dto.setDob(data.dob);
        dto.setGender(data.gender);
        dto.setMaritalStatus(data.maritalStatus);
        dto.setOffice(data.office);
        dto.setPhone(data.phone);
        dto.setSsn(data.ssn);
        dto.setAddress(Optional.ofNullable(data.address)
                .map(AddressMapper::toDto)
                .orElse(null));
        dto.setName(Optional.ofNullable(data.name)
                .map(NameInfoMapping::toDto)
                .orElse(null));
        return dto;
    }

    public static EmployeeData fromDto(Employee dto) {
        EmployeeData data = new EmployeeData(dto.getId(), dto.getEmployerId(), dto.getEmail());
        data.annualPay = dto.getAnnualPay();
        data.department = dto.getDepartment();
        data.dob = dto.getDob();
        data.gender = dto.getGender();
        data.maritalStatus = dto.getMaritalStatus();
        data.office = dto.getOffice();
        data.phone = dto.getPhone();
        data.ssn = dto.getSsn();
        data.address = Optional.ofNullable(dto.getAddress())
                .map(AddressMapper::fromDto)
                .orElse(null);
        data.name = Optional.ofNullable(dto.getName())
                .map(NameInfoMapping::fromDto)
                .orElse(null);
        return data;
    }
}
