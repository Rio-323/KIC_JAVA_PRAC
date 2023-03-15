class Student {
    String hakbun;
    String name;
    int age;
    double height;
    double weight;
}

public class ObjectEx01 {
    public static void main(String[] args) {
        // 객체변수 선언과 동시에 객체변수 생성
        Student stu1 = new Student();

        // Student@123772c4 - 주소값
        System.out.println(stu1);

        stu1.hakbun = "1001";
        stu1.name = "홍길동";
        stu1.age = 22;
        stu1.height = 180.5;
        stu1.weight = 80;

        System.out.println(stu1.name);

        Student stu2 = new Student();
        System.out.println(stu2);
        stu2.hakbun = "1002";
        stu2.name = "박문수";
        stu2.age = 20;
        stu2.height = 170;
        stu2.weight = 75;
        System.out.println(stu2.name);
    }
}
