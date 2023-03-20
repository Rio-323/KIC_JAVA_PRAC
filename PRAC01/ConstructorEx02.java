class Constructor2 {
    String data1;

    // overloading
    Constructor2() {
        this.data1 = "10";
        System.out.println("data1 : " + this.data1);
    }

    Constructor2(String data1) {
        this.data1 = data1;
        System.out.println("data1 : " + this.data1);
    }
}

public class ConstructorEx02 {
    public static void main(String[] args) {
        Constructor2 c = new Constructor2("20");
        Constructor2 c2 = new Constructor2();
    }
}
