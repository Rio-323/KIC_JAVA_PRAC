class Parent4 {
    void viewParent() {
        System.out.println("viewParent() 호출 : " + this);
    }
}

class Child5 extends Parent4 {
    @Override
    void viewParent() {
        System.out.println("child viewParent() 호출 : " + this);
    }
}

public class OverridingEx01 {
    public static void main(String[] args) {
        Child5 c = new Child5();
        c.viewParent(); 
    }
}
