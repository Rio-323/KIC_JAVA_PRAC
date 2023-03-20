import java.net.SocketTimeoutException;

public class VariableEx04 {
    public static void main(String[] args) {
        // char - 문자 - ''
        // String - 문자열(여러자) = ""
        char c1 = 'a';
        char c2 = 'b';
        System.out.println(c1);
        System.out.println(c2);

        // ascII
        char c3 = 97;
        System.out.println(c3);

        // 다국어 - uniCode
        char c4 = '\uc790';
        System.out.println(c4);

        // 특수문자
        // \n - enter, \t - tab
        char e1 = 'a';
        char e2 = '\t';
        char e3 = 'b';

        System.out.print(e1);
        System.out.print(e2);
        System.out.print(e3);
    }
}
