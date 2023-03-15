class MethodEx2 {

    // 같은 이름 두 개의 메서드는 선언이 안됨.
    // 허용 - 마라미터의 종류 / 개수 / 순서
    // 메서드 중복 정의 : 오버로딩
    // 오버로딩 - 오버로딩(overloading)은 새로운 메소드를 정의하는 것입니다. 하지만 오버라이딩(overriding)은 상속받은 기존의 메소드를 재정의하는 것입니다.

    void doFunc(int a) {
        System.out.println("doFunc(int a) 호출");
    }

    void doFunc(String s) {
        System.out.println("doFunc(String s) 호출");
    }

    void doFunc(String s, int a) {
        System.out.println("doFunc(String s, int a) 호출");
    }
}

public class MainEx04 {
    public static void main(String[] args) {
       MethodEx2 ex = new MethodEx2();
       ex.doFunc(10);
       ex.doFunc("10");
       ex.doFunc("10", 10);
    }
}
