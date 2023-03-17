class Parent6 {
    // Parent6() {
    //     System.out.println("Parent 생성자 호출");
    // }

    Parent6(String data) {
        System.out.println("Parent(String data) 생성자 호출");
    }
}

class Child7 extends Parent6 {
    Child7() {

        // super - 멤버 / super()  - 생성자 : this / this()
        super("10");
        System.out.println("Child 생성자 호출");
    }
}

public class ConstructorEx04 {
    public static void main(String[] args) {
        Child7 c = new Child7();

    }
}
