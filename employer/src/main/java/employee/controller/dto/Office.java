package employee.controller.dto;

/**
 * Created by idimaster on 5/17/17.
 */
public class Office {
    private String name;
    private String code;
    private Address address;

    public Office() {
    }

    public Office(String name, String code) {
        this.name = name;
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public Address getAddress() {
        return address;
    }

    public void setAddress(Address address) {
        this.address = address;
    }
}
