class Constructor {
    // 생성자는 없으면 컴파일러가 생성 = 디폴트 생성자
    // Constructor() {}
    Constructor() {
        System.out.println("디폴트 생성자 호출");
    }

    void doFunc1() {
        System.out.println("doFunc1() 호출");
    }
}

public class ConstructorEx01 {
    public static void main(String[] args) {
        Constructor c = new Constructor();
        c.doFunc1();
    }
}
