import javax.swing.text.html.HTMLDocument.BlockElement;

public class OperatorEx03 {
    public static void main(String[] args) {
        int a = 7;
        int b = 2;

        boolean result;

        result = (a -= 3) > 7 && (b += 1) < 7;
        System.out.println(result);
        System.out.println(a + " / " + b);
    }
}
