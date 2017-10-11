package employee.controller.mapping;

import employee.controller.dto.Department;
import employee.domain.DepartmentData;

/**
 * Created by idimaster on 5/17/17.
 */
public class DepartmentMapper {
    public static Department toDto(DepartmentData data) {
        return new Department(data.name, data.code);
    }

    public static DepartmentData fromDto(Department dep) {
        return new DepartmentData(dep.getName(), dep.getCode());
    }
}
