package effective.protectedCloneClass;

import java.util.Date;

public class testv1 {
    public static void main(String[] args) {
        Date startv1 = new Date();
        Date endv1 = new Date();
        ProtectedCloneClassV1 p1 = new ProtectedCloneClassV1(startv1, endv1);
        // 引用传递带来的问题，结束时间被修改了，比开始时间还要早。
        endv1.setYear(78);
        System.out.println("start:" + p1.getStart());
        System.out.println("end:" + p1.getEnd());

        System.out.println("=====================================>");

        Date startv2 = new Date();
        Date endv2 = new Date();
        ProtectedCloneClassV2 p2 = new ProtectedCloneClassV2(startv2, endv2);
        // 引用传递带来的问题，结束时间被修改了，比开始时间还要早。
        p2.getEnd().setYear(78);
        System.out.println("start:" + p2.getStart());
        System.out.println("end:" + p2.getEnd());

        System.out.println("=====================================>");

        Date startv3 = new Date();
        Date endv3 = new Date();
        ProtectedCloneClassV3 p3 = new ProtectedCloneClassV3(startv3, endv3);
        // 引用传递带来的问题，结束时间被修改了，比开始时间还要早。
        p3.getEnd().setYear(78);
        System.out.println("start:" + p3.getStart());
        System.out.println("end:" + p3.getEnd());

    }
}
