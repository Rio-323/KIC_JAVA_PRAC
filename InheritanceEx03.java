class Parent3 {
    void viewParent() {
        System.out.println("viewParent() 호출 : " + this);
    }
}

class Child4 extends Parent3 {
    void viewChild() {
        System.out.println("viewChild() 호출 : " + this);
    }
}

public class InheritanceEx03 {
    public static void main(String[] args) {
        Child4 c = new Child4();
        System.out.println(c);
        c.viewChild();
        c.viewParent();
    }
}
