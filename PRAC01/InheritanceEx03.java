class Parent3 {
    private String p1 = "홍길동";
    public String p2 = "박문수";
    String p3 = "이몽룡";

    void viewParent() {
        System.out.println("viewParent() 호출 : " + this);
    }
}

class Child4 extends Parent3 {
    void viewChild() {
        System.out.println("viewChild() 호출 : " + this);

        // System.out.println(p1);
        System.out.println(p2);
        System.out.println(p3);
    }

    // 메서드 재정의
    @Override
    void viewParent() {
        System.out.println("child viewParent() 호출 : " + this);
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
