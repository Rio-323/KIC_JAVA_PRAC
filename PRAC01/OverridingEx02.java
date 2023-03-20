class Parent5 {
    String p = "홍길동";
    void viewParent() {
        System.out.println("viewParent() 호출 : " + this);
    }
}

class Child6 extends Parent5 {
    String p = "박문수";
    @Override
    void viewParent() {
        System.out.println("child viewParent() 호출 : " + this);

        // super - 부모클래스에 있는 것을 가져오는 것.
        super.viewParent();
        System.out.println(p);
        System.out.println(this.p);
        System.out.println(super.p);
    }
}

public class OverridingEx02 {
    public static void main(String[] args) {
        Child6 c = new Child6();
        c.viewParent();
    }
}
