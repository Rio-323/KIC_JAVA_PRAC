interface InterA {
    // 상수
    public static final String STR1 = "홍길동";

    // abstract method
    public abstract void methodA();
    void methodB(); // - abstract 생략 선언도 가능
}

class ClassA implements InterA {
    public void methodA() {
        System.out.println("methodA 호출");
    }

    public void methodB() {
        System.out.println("methodB 호출");
    }
}

public class MainEx02 {
    public static void main(String[] args) {
        // InterA a = new InterA();
        ClassA a = new ClassA();
        a.methodA();
    }
}
