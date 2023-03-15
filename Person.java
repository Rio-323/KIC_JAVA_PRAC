public class Person {
    String name;
    int age;
    boolean isHungry;

    // 매서드
    void eat() {
        System.out.println("냠냠");
        isHungry = false;
    }

    void work() {
        System.out.println("열심히");
        isHungry = true;
    }
}
