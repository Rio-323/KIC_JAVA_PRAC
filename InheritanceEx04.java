class GrandChild extends Child4 {
    void viewGrandChild() {
        System.out.println("viewGrandChild() 호출 : " + this);
    }
}

public class InheritanceEx04 {
    public static void main(String[] args) {
        GrandChild gc = new GrandChild();
        gc.viewChild();
        gc.viewGrandChild();
        gc.viewParent();

        Child4 c = new Child4();
        // System.out.println(c.p1);
        System.out.println(c.p2);
        System.out.println(c.p3);
    }
}
