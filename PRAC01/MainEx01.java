class MethodEx {
    // 단순한 메서드 선언
    void doFunc1() {
        System.out.println("doFunc1()호출");
    }

    void doFunc2(int data1) {
        int data0 = 10;
        System.out.println("doFunc2() 호출 " + data0);
        System.out.println("doFunc2() 호출 " + data1);
    }

    void doFunc3(int data1, String data2) {
        System.out.println("doFunc3() 호출 " + data1);
        System.out.println("doFunc3() 호출 " + data2);
    }

    // void - return 값이 없음
    int doFunc4(int data1, int data2) {
        int sum = data1 + data2;
        return sum;
    }
}

public class MainEx01 {
    public static void main(String[] args) {
        MethodEx ex = new MethodEx();
        ex.doFunc1();
        ex.doFunc2(10);
        ex.doFunc3(10, "abc");
        System.out.println(ex.doFunc4(10, 20));
    }
}
