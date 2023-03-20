import javax.swing.plaf.synth.SynthOptionPaneUI;

public class PrintEx01{
    public static void main(String[] args) {
        // System.out.println - ln(enter)
        System.out.println("Hello Print");
        System.out.println("Hello Print");
        System.out.println("Hello Print");

        System.out.print("Hello Print");
        System.out.print("Hello Print");
        System.out.print("Hello Print");

        // f
        // %s 문자열, %d 숫자, \n
        System.out.printf( "%s %s\n", "Hello", "World");
        System.out.printf("%d %d\n", 10, 20);
    }
}

