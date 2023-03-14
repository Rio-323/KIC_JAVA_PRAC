public class TypeCastingEx02 {
    public static void main(String[] args) {
        int i1 = 20;

        // 명시적 형변환
        // (자료형) - 형변환 연산자
        short s1 = (short)i1;
        System.out.println(s1);

        char c1 = 'A';
        int i2 = c1 + 3;
        System.out.println(i2);
        System.out.println((char)i2);
    }
}
