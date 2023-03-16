class Modifier {
    String data1 = "default";
    public String data2 = "public";
    private String data3 = "private";

    public String getData3() {
        return data3;
    }

    void viewData1() {
        System.out.println(this.data1);
        System.out.println(this.data2);
        System.out.println(this.data3);
    }
}

public class ModifierEx01 {
    public static void main(String[] args) {
        Modifier m = new Modifier();
        System.out.println(m.data1);
        System.out.println(m.data2);
        // System.out.println(m.data3);

        System.out.println(m.getData3());
        m.viewData1();
    }
}
