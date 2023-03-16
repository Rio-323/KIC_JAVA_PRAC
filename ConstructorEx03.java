class Constructor3 {
    String data1;
    String data2;

    // overloading
    Constructor3() {
        // this.data1 = "10";
        // this.data2 = "20";
        // System.out.println("data1 : " + this.data1);
        // System.out.println("data2 : " + this.data2);
        // System.out.println("시작");
        // 생성자는 첫 문장에 와야한다.
        this("10", "20");
        // 생성자는 일반 메서드 처럼 호출 불가능
        // Constructor3("10", "20");
    }

    Constructor3(String data1) {
        // this.data1 = data1;
        // this.data2 = "20";
        // System.out.println("data1 : " + this.data1);
        // System.out.println("data2 : " + this.data2);

        this(data1, "20");
    }

    Constructor3(String data1, String data2) {
        this.data1 = data1;
        this.data2 = data2;
        System.out.println("data1 : " + this.data1);
        System.out.println("data2 : " + this.data2);
    }
}

public class ConstructorEx03 {
    public static void main(String[] args) {
      Constructor3 c1 = new Constructor3();
      System.out.println();

      Constructor3 c2 = new Constructor3("30");
      System.out.println();

      Constructor3 c3 = new Constructor3("30", "40");
    }
}
