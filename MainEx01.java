class Parent1 {
    Parent1() {
        System.out.println("Parent1 생성자 호출");
    }
}

abstract class Parent2 {
    Parent2() {
        System.out.println("Parent2 생성자 호출");
    }

    // 추상 메서드 - 내용이 선언되지 않은 메서드
    void viewParent1() {}
    abstract void viewParent2();
}

class Child2 extends Parent2 {
    Child2() {
        System.out.println("Child2 생성자 호출");
    }

    // abstract void viewParent2(); - 일반 클래스는 추상 메서드를 가질 수 없음

    // void viewParent2() {
    //     System.out.println("Child2 viewParent2 호출");
    // }
}

class GrandChild2 extends Child2 {
    void viewParent2() {
        System.out.println("Child2 viewParent2 호출");
    }
}

public class MainEx01 {
    public static void main(String[] args) {
        Parent1 p1 = new Parent1();
        // Parent2 p2 = new Parent2(); - 불완전
        Child2 c2 = new Child2();
    }
}