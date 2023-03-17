class Parent8 {
    Parent8() {
        System.out.println("Parent8 생성자 호출");
    }
}

class Child9 extends Parent8 {
    Child9() {
        System.out.println("Child9 생성자 호출");
    }
}

public class CastingEx01 {
    public static void main(String[] args) {
        Child9 c1 = new Child9();
        Child9 c2 = c1;

        System.out.println(c1);
        System.out.println(c2);

        // 형변화
        Parent8 p1 = c1;
        System.out.println(p1);

        Parent8 p2 = new Child9();

        Child9 c3 = (Child9)p1;
        System.out.println(c3);

        // 부모클래스가 자식클래스는 될 수는 있어도 자식클래스가 부모클래스가 될 수는 없음
        // Child9 c4 = new Parent8();
    }
}
