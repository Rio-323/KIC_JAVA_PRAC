public class ArrayEx03 {
    public static void main(String[] args) {
        
        int[] intArr = new int[3];

        System.out.println(intArr[0]);

        // Runtime Exception - ArrayIndexOutOfBoundsException
        System.out.println(intArr[5]);
    }
}
