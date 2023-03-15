class MethodEx3 {
    void doFunc(int ... args) {
        System.out.println("doFunc() 호출");
        System.out.println(args.length);
        for (int i = 0; i < args.length; i++) {
            System.out.println(args[i]);
        }
    }
}

public class MainEx05 {
    public static void main(String[] args) {
       MethodEx3 ex = new MethodEx3();
       ex.doFunc(10, 10);
       ex.doFunc(10, 10, 20);
    }
}
