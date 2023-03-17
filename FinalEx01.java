// final 클래스는 상속 불가능
class Parent7 {
    Parent7() {
        System.out.println("Parent7 생성자 호출");
    }

    void viewParent() {
        System.out.println("Parent viewParent() 호출");
    }
}

class Child8 extends Parent7 {
    Child8() {
        System.out.println("Child8 생성자 호출");
    }

    @Override
    void viewParent() {
        System.out.println("Child8 viewParent() 호출");
    }
}

public class FinalEx01 {
    public static void main(String[] args) {
        Child8 c = new Child8();
        c.viewParent();
    }
}
