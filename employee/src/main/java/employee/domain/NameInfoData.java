package employee.domain;

import org.springframework.data.cassandra.mapping.UserDefinedType;

/**
 * Created by idimaster on 5/18/17.
 */
@UserDefinedType("nameInfo")
public class NameInfoData {
    public String first;
    public String last;
    public String middle;

    public NameInfoData() {
    }

    public NameInfoData(String first, String last, String middle) {

        this.first = first;
        this.last = last;
        this.middle = middle;
    }
}
