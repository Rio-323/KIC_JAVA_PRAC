public class LoopEx04 {
    public static void main(String[] args) {
       int i = 1;
       while(i <= 9) {
        System.out.print(i + "단 : ");
        int j = 1;
        while(j <= 9) {
            System.out.printf("%s X %s = %s\t", i, j, (i*j));
            j++;
        }
        i++;
        System.out.println();
       }
    }
}
