package employee.controller.mapping;

import employee.controller.dto.Employer;
import employee.controller.dto.EmployerInfo;
import employee.domain.EmployerData;

import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Created by idimaster on 5/17/17.
 */
public class EmployerMapping {

    public static EmployerInfo toInfo(EmployerData emp) {
        EmployerInfo dto = new EmployerInfo();
        dto.setId(emp.id);
        dto.setName(emp.name);
        dto.setDescription(emp.description);
        return dto;
    }

    public static Employer toDto(EmployerData emp) {
        Employer dto = new Employer(emp.id);
        dto.setName(emp.name);
        dto.setDescription(emp.description);
        dto.setAddress(Optional.ofNullable(emp.address)
                .map(AddressMapper::toDto)
                .orElse(null));
        dto.setOffices(Optional.ofNullable(emp.offices)
                .map(offices -> offices.stream()
                        .map(OfficeMapper::toDto)
                        .collect(Collectors.toList())
                ).orElse(null));
        dto.setDepartments(Optional.ofNullable(emp.departments)
                .map(deps -> deps.stream()
                        .map(DepartmentMapper::toDto)
                        .collect(Collectors.toList())
                ).orElse(null));
        return dto;
    }

    public static EmployerData fromDto(Employer emp) {
        EmployerData data = new EmployerData(emp.getId(), emp.getName());
        data.description = emp.getDescription();
        data.address = Optional.ofNullable(emp.getAddress())
                .map(AddressMapper::fromDto)
                .orElse(null);
        data.offices = Optional.ofNullable(emp.getOffices())
                .map(offices -> offices.stream()
                        .map(OfficeMapper::fromDto)
                        .collect(Collectors.toSet())
                ).orElse(null);
        data.departments = Optional.ofNullable(emp.getDepartments())
                .map(deps -> deps.stream()
                        .map(DepartmentMapper::fromDto)
                        .collect(Collectors.toSet())
                ).orElse(null);
        return data;
    }
}
