class Parent10 {
    void viewParent() {
        System.out.println("Parent viewParent() 호출");
    }
}

class Child11 extends Parent10 {
    @Override
    void viewParent() {
        System.out.println("Child11 viewParent() 호출");
    }
}

class Child12 extends Parent10 {
    @Override
    void viewParent() {
        System.out.println("Child12 viewParent() 호출");
    }
}

public class CastingEx03 {
    public static void main(String[] args) {
       /* 
        Child11 c1 = new Child11();
       c1.viewParent();

       Child12 c2 = new Child12();
       c2.viewParent();
       */

       Parent10 p = new Child11();
       p.viewParent();

       p = new Child12();
       p.viewParent();

    }
}
