package employee.controller.mapping;

import employee.controller.dto.NameInfo;
import employee.domain.NameInfoData;

/**
 * Created by idimaster on 5/18/17.
 */
public class NameInfoMapping {
    public static NameInfo toDto(NameInfoData data) {
       return new NameInfo(data.first, data.last, data.middle);
    }

    public static NameInfoData fromDto(NameInfo dto) {
        return new NameInfoData(dto.getFirst(), dto.getLast(), dto.getMiddle());
    }
}
