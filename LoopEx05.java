public class LoopEx05 {
    public static void main(String[] args) {
       int i = 1;
       do {
            System.out.print(i + "단 : ");
            int j = 1;
            do{
                System.out.printf("%s X %s = %s\t", i, j, (i*j));
                j++;
            } while(j <= 9);

            i++;
            System.out.println();
       } while( i <= 9);
      
    }
}
