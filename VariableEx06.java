public class VariableEx06 {
    public static void main(String[] args) {
        // 숫자 자료형
        // 정수형 - byte, short, int, long
        // 실수형 - float, double

        int i = 1;
        System.out.println(i);

        byte b = 1;
        short s = 1;
        long l = 1L;
        System.out.println(b);
        System.out.println(s);
        System.out.println(l);

        // byte b1 = 129;
        // System.out.println(b1);

        // 진수
        int i2 = 0b1010;
        int i8 = 030;
        int i16 = 0xA4;
        System.out.println(i2);
        System.out.println(i8);
        System.out.println(i16);

        // 큰수
        int big1 = 1000000;
        int big2 = 1_000_000;
        System.out.println(big1);
        System.out.println(big2);
    }
}
