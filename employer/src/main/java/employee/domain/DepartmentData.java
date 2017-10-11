package employee.domain;

import org.springframework.data.cassandra.mapping.UserDefinedType;

/**
 * Created by idimaster on 5/17/17.
 */
@UserDefinedType("department")
public class DepartmentData {
    public String name;
    public String code;

    public DepartmentData(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
