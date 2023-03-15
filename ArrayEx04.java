public class ArrayEx04 {
    public static void main(String[] args) {
        int[] intArr1 = new int[] {10, 20, 30};
        int[] intArr2 = {10, 20, 30};
        String[] strArr = {"aaa", "bbb", "ccc"};

        for (int i = 0; i < intArr1.length; i++) {
            System.out.println(intArr1[i]);
        }
        System.out.println();

        for (int i = 0; i < intArr2.length; i++) {
            System.out.println(intArr2[i]);
        }
        System.out.println();

        for (int i = 0; i < strArr.length; i++) {
            System.out.println(strArr[i]);
        }
        System.out.println();

        // 향상된 for : for each

        for(int data : intArr1) {
            System.out.println(data);
        }
        System.out.println();

        for(int data : intArr2) {
            System.out.println(data);
        }
        System.out.println();

        for(String data : strArr) {
            System.out.println(data);
        }
    }
}
