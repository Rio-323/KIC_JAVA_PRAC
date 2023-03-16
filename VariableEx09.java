class Variable2 {
    String instanceVariable;
    static String classVariable;

    void doFunc1() {
        System.out.println("doFunc1() 호출");
        System.out.println(instanceVariable);
        System.out.println(classVariable);
    }

    static void doFunc2() {
        System.out.println("doFunc2() 호출");
        // System.out.println(instanceVariable);
        System.out.println(classVariable);
    }
}

public class VariableEx09 {
    public static void main(String[] args) {
        /*Variable2 v1 = new Variable2();
        Variable2 v2 = new Variable2();

        v1.instanceVariable = "10";
        v2.instanceVariable = "20";

        System.out.println(v1.instanceVariable);
        System.out.println(v2.instanceVariable);

        // 클래스 멤버 변수 - 공유 데이터
        Variable2.classVariable = "30";
        System.out.println(Variable2.classVariable);
        System.out.println(Variable2.classVariable);

        v1.doFunc1();
        v2.doFunc1();

        // 클래스 메서드
        Variable2.doFunc2();*/

        Variable2.classVariable = "30";

        Variable2.doFunc2();
    }
}
