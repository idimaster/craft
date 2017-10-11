package employee.domain;

import org.springframework.data.cassandra.mapping.UserDefinedType;

/**
 * Created by idimaster on 5/17/17.
 */
@UserDefinedType("address")
public class AddressData {
    public String street;
    public String streetExt;
    public String state;
    public String zip;
    public String country;

    public AddressData(String street, String state, String zip) {
        this.street = street;
        this.state = state;
        this.zip = zip;
    }
}
