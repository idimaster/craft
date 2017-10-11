package employee.controller.dto;

/**
 * Created by idimaster on 5/17/17.
 */
public class Address {
    private String street;
    private String streetExt;
    private String state;
    private String zip;
    private String country;

    public Address() {
    }

    public Address(String street, String state, String zip) {
        this.street = street;
        this.state = state;
        this.zip = zip;
        this.country = "US";
    }

    public String getStreet() {
        return street;
    }

    public void setStreet(String street) {
        this.street = street;
    }

    public String getStreetExt() {
        return streetExt;
    }

    public void setStreetExt(String streetExt) {
        this.streetExt = streetExt;
    }

    public String getState() {
        return state;
    }

    public void setState(String state) {
        this.state = state;
    }

    public String getZip() {
        return zip;
    }

    public void setZip(String zip) {
        this.zip = zip;
    }

    public String getCountry() {
        return country;
    }

    public void setCountry(String country) {
        this.country = country;
    }
}
