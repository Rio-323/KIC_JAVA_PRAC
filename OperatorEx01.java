public class OperatorEx01 {
    public static void main(String[] args) {
        // 산술 연산자
        int i1 = 10;
        int i2 = 20;
        int sum1 = i1 + i2;
        System.out.println(sum1);

        short s1 = 10;
        short s2 = 20;
        // int sum2 = s1 + s2;
        short sum2 = (short)(s1 + s2);
        System.out.println(sum2);
    }
}
