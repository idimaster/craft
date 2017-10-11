package employee.controller.mapping;

import employee.controller.dto.Office;
import employee.domain.OfficeData;

import java.util.Optional;

/**
 * Created by idimaster on 5/17/17.
 */
public class OfficeMapper {
    public static Office toDto(OfficeData data) {
        Office dto = new Office(data.name, data.code);
        dto.setAddress(Optional.ofNullable(data.address)
                .map(AddressMapper::toDto)
                .orElse(null));
        return dto;
    }

    public static OfficeData fromDto(Office office) {
        OfficeData data = new OfficeData(office.getName(), office.getCode());
        data.address = Optional.ofNullable(office.getAddress())
                .map(AddressMapper::fromDto)
                .orElse(null);
        return data;
    }
}
