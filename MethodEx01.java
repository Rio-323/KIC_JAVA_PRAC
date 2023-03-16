class Method {
    String data1;

    void doFunc1(String data1) {
        this.data1 = data1;
        System.out.println("doFunc1() 호출 : " + data1);
        System.out.println("doFunc1() 호출 : " + this.data1);
        // this 자기 참조 연산자
        System.out.println("this : " + this);
    }
}

public class MethodEx01 {
    public static void main(String[] args) {
        Method m1 = new Method();
        m1.doFunc1("Hi");
        System.out.println("m1 : " + m1);

        Method m2 = new Method();
        m2.doFunc1("10");
        System.out.println("m2 : " + m2);
    }
}
