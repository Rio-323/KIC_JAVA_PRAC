public class OperatorEx02 {
    public static void main(String[] args) {
        int i1 = 1_000_000;
        int i2 = 2_000_000;

        // 오버 플로우(담을 수 있는 수를 넘어섰음.)
        // int product = i1 * i2;
        long product = (long)i1 * i2;
        System.out.println(product);
    }
}
