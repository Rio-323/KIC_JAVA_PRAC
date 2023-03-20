public class VariableEx10 {
    String instanceVariable = "10";
    static String classVariable = "20";

    void doFunc1() {
        System.out.println("doFunc1() 호출");
    }

    static void doFunc2() {
        System.out.println("doFunc2() 호출");
    }
    public static void main(String[] args) {
        // System.out.println(instanceVariable);
        System.out.println(classVariable);

        VariableEx10 v1 = new VariableEx10();
        v1.instanceVariable = "20";
        System.out.println(v1.instanceVariable);
        v1.doFunc1();
        doFunc2();
    }
}
