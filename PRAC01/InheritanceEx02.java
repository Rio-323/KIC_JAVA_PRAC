class Parent2 {
    void viewParent() {
        System.out.println("viewParent() 호출");
    }
}

class Child3 extends Parent2 {
    void viewChild() {
        System.out.println("viewChild() 호출");
    }
}

public class InheritanceEx02 {
    public static void main(String[] args) {
        Child3 c = new Child3();
        c.viewChild();
        c.viewParent();
        System.out.println(c.toString());

        Parent2 p = new Parent2();
        p.viewParent();

        // Object 상속(생략)
        p.toString();
    }
}
