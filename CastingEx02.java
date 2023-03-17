class Parent9 {
    Parent9() {
        System.out.println("Parent9 생성자 호출");
    }

    void viewParent1() {
        System.out.println("Parent9 viewParent1() 호출");
    }

    void viewParent2() {
        System.out.println("Parent9 viewParent2() 호출");
    }
}

class Child10 extends Parent9 {
    Child10() {
        System.out.println("Child10 생성자 호출");
    }

    void viewChild1() {
        System.out.println("Child10 viewChild1() 호출");
    }

    @Override
    void viewParent2() {
        System.out.println("Child10 viewParent2() 호출");
    }
}

public class CastingEx02 {
    public static void main(String[] args) {
       Child10 c1 = new Child10();
       c1.viewChild1();
       c1.viewParent2();
       c1.viewParent1();
       System.out.println();

       // 형변환
       Parent9 p1 = new Child10();
       // p1.viewChild1(); - 호출 불가능
       p1.viewParent1();     // Parent
       p1.viewParent2();     // Child
    }
}
