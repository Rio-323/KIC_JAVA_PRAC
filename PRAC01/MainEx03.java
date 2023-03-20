class Util2 {

    int doCalculator(int data1, int data2, String data3) {
        int calc = 0;

        if(data3 == "+") {
            calc = data1 + data2;
        } else if(data3 == "-") {
            calc = data1 - data2;
        } else if(data3 == "*") {
            calc = data1 * data2;
        }
        return calc;
    }    
}

public class MainEx03 {
    public static void main(String[] args) {
        Util2 util = new Util2();
        int result = util.doCalculator(10, 20, "+");

        System.out.println(result);
    }
}
