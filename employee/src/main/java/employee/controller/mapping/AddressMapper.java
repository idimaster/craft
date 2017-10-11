package employee.controller.mapping;

import employee.controller.dto.Address;
import employee.domain.AddressData;

/**
 * Created by idimaster on 5/17/17.
 */
public class AddressMapper {
    public static Address toDto(AddressData addr) {
        Address dto = new Address(addr.street, addr.state, addr.zip);
        dto.setCountry(addr.country);
        dto.setStreetExt(addr.streetExt);
        return dto;
    }

    public static AddressData fromDto(Address addr) {
        AddressData data = new AddressData(addr.getStreet(), addr.getState(), addr.getZip());
        data.country = addr.getCountry();
        data.streetExt = addr.getStreetExt();
        return data;
    }
}
