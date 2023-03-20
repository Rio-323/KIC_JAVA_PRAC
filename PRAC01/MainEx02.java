class Util {
    int viewMaxNumber(int data1, int data2, int data3) {
        int num = 0;

       if(data1 >= data2 && data1 >= data3) {
            num = data1;
       } else if(data2 >= data1 && data2 >= data3) {
            num = data2;
       } else if(data3 >= data1 && data3 >= data2) {
            num = data3;
       }

       return num;
    }    
}

public class MainEx02 {
    public static void main(String[] args) {
        Util util = new Util();
        int result = util.viewMaxNumber(20, 10, 30);
        System.out.println("최고값 : " + result);
    }
}
