package employee.controller.dto;

/**
 * Created by idimaster on 5/17/17.
 */
public class NameInfo {
    private String first;
    private String last;
    private String middle;

    public NameInfo() {
    }

    public NameInfo(String first, String last, String middle) {
        this.first = first;
        this.last = last;
        this.middle = middle;
    }

    public String getFirst() {
        return first;
    }

    public void setFirst(String first) {
        this.first = first;
    }

    public String getLast() {
        return last;
    }

    public void setLast(String last) {
        this.last = last;
    }

    public String getMiddle() {
        return middle;
    }

    public void setMiddle(String middle) {
        this.middle = middle;
    }
}
