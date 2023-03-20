public class LoopEx01 {
    public static void main(String[] args) {
        for (int i = 0, j = 0; i < 10; i++, j += 2) {
            System.out.print(i + j + "\t");
        }
        System.out.println();

        int i = 0, j = 0;
        for( ; i < 10; i++, j += 2) {
            System.out.print(i + j + "\t");
        }
    }
}
