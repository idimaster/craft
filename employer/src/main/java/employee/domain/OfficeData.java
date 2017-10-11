package employee.domain;

import org.springframework.data.cassandra.mapping.UserDefinedType;

/**
 * Created by idimaster on 5/17/17.
 */
@UserDefinedType("office")
public class OfficeData {
    public String name;
    public String code;
    public AddressData address;

    public OfficeData(String name, String code) {
        this.name = name;
        this.code = code;
    }
}
