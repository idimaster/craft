package employee.controller.mapping;

import employee.controller.dto.EmployeeUpdate;
import employee.domain.EmployeeUpdateData;

import java.util.Optional;

/**
 * Created by idimaster on 5/18/17.
 */
public class EmployeeUpdateMapping {
    public static EmployeeUpdate toDto(EmployeeUpdateData data) {
        EmployeeUpdate dto = new EmployeeUpdate(data.id, data.employeeId, data.effective);
        dto.setPhone(data.phone);
        dto.setAddress(Optional.ofNullable(data.address)
                .map(AddressMapper::toDto)
                .orElse(null));
        return dto;
    }

    public static EmployeeUpdateData fromDto(EmployeeUpdate dto) {
        EmployeeUpdateData data = new EmployeeUpdateData(dto.getId(), dto.getEmployeeId(), dto.getEffective());
        data.phone = dto.getPhone();
        data.address = Optional.ofNullable(dto.getAddress())
                .map(AddressMapper::fromDto)
                .orElse(null);
        return data;
    }
}
