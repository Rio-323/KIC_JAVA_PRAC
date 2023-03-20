public class LoopEx02 {
    public static void main(String[] args) {

        String str = "";
       for (int i = 0; i < 10; i++) {
           str += "*";
           System.out.println(str);
       }
       System.out.println();

       for (int i = 0; i < 10; i++) {
            for (int j = 0; j < 10 && j <= i; j++) {
                System.out.print("*");
            }
            System.out.println();
       }
       System.out.println();

       char str1 = 'A';
       // System.out.println((int)str1);

      String str3 = "";

       for (int i = 0; i < 10; i++) {
            char str2;
            str2 = (char)((int)str1 + i);
            str3 += (char)str2;
            System.out.println(str3);
       }
       System.out.println();

       for (int i = 0; i <= 9; i++) {
            for (int j = 65; j <= 65+i; j++) {
                System.out.print((char)j);
            }
            System.out.println();
       }
    }
}
