class Parent {
    String p = "부모";
    void viewParent() {
        System.out.println("viewParent() 호출");
    }
}

class Child1 {
    String c = "자식";
    void viewChild() {
        System.out.println("viewChild() 호출");
    }
}

class Child2 extends Parent {
    String c = "자식";
    void viewChild() {
        System.out.println("viewChild() 호출");
    }

    @Override
    void viewParent() {
        System.out.println("Override 호출");
    }
}

public class InheritanceEx01 {
    public static void main(String[] args) {
        Parent p = new Parent();
        p.viewParent();
        System.out.println(p.p);

        Child1 c1 = new Child1();
        c1.viewChild();
        System.out.println(c1.c);

        Child2 c2 = new Child2();
        c2.viewChild();
        c2.viewParent();
        System.out.println(c2.c);
        System.out.println(c2.p);
    }
}
