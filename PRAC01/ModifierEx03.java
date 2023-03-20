class Modifier2 {
    private String data;

    // 메서드를 통해서 접근
    void viewData() {
        this.data = "data";
        System.out.println(data);
    }

    // setter(값을 입력)
    public void setData(String data) {
        this.data = data;
    }

    // getter(값을 출력)
    public String getData() {
        return data;
    }
}

public class ModifierEx03 {
    public static void main(String[] args) {
        Modifier2 m = new Modifier2();
        // System.out.println(m.data);
        // m.viewData();
        m.setData("data");
        System.out.println(m.getData());
    }
}
