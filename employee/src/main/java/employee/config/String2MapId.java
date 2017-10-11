package employee.config;

import org.springframework.core.convert.converter.Converter;
import org.springframework.data.cassandra.repository.MapId;
import org.springframework.data.cassandra.repository.support.BasicMapId;

import java.util.UUID;

/**
 * Created by idimaster on 5/17/17.
 */
public class String2MapId implements Converter<String, MapId> {
    @Override
    public MapId convert(String s) {
        return new BasicMapId().with("id", UUID.fromString(s));
    }
}
