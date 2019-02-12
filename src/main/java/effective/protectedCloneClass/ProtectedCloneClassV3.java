package effective.protectedCloneClass;

import java.util.Date;

public class ProtectedCloneClassV3 {
    private final Date start;
    private final Date end;

    public ProtectedCloneClassV3(Date start, Date end) {
        this.start = new Date(start.getTime());
        this.end = new Date(end.getTime());
        // 约束条件：周期的起始时间（start）不能在结束时间（end）之后
        if (start.compareTo(end) > 0) {
            throw new IllegalArgumentException(start + "after" + end);
        }


    }

    public Date getStart() {
        return new Date(start.getTime());
    }

    public Date getEnd() {
        return new Date(end.getTime());
    }

}
