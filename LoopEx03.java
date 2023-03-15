public class LoopEx03 {
    public static void main(String[] args) {
        for (int i = 1; i < 10 ; i++) {
            System.out.print(i + "단 : ");
            for (int j = 1; j < 10; j++) {
                // System.out.print(i + " X " + j + " = " + (i*j) + "\t");
                System.out.printf("%s X %s = %s\t", i, j, (i*j));
            }
            System.out.println();
        }
    }
}
