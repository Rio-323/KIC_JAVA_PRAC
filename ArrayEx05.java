public class ArrayEx05 {
    public static void main(String[] args) {
        // 행 / 열
        int[][] arr1;

        // 3행 2열
        arr1 = new int[3][2];

        arr1[0][0] = 10;
        arr1[0][1] = 20;
        arr1[1][0] = 30;
        arr1[1][1] = 40;
        arr1[2][0] = 50;
        arr1[2][1] = 60;
        System.out.println(arr1[0][0]);
        System.out.println(arr1[2][1]);
        System.out.println();

        int[][] arr2 = new int[][] {{10, 20}, {30, 40}, {50, 60}};
        System.out.println(arr2[0][0]);
        System.out.println(arr2[2][1]);
        System.out.println();

        int[][] arr3 = {{10, 20}, {30, 40}, {50, 60}};
        System.out.println(arr3[0][0]);
        System.out.println(arr3[2][1]);
        System.out.println();

        System.out.println(arr1);
        System.out.println(arr1[0]);
        System.out.println(arr1[0][0]);
        System.out.println();

        System.out.println("arr1 : " + arr1);
        System.out.println("arr1[0] : " + arr1[0]);
        System.out.println("arr1[0][0] : " + arr1[0][0]);
        System.out.println();

        // 반복문 전체 데이터 접근
        System.out.println("arr1.length : " + arr1.length);
        System.out.println("arr1[0].length : " + arr1[0].length);
        System.out.println();

        for (int i = 0; i < arr1.length; i++) {
            for (int j = 0; j < arr1[i].length; j++) {
                System.out.println(arr1[i][j]);
            }
        }
        System.out.println();

        // 향상된 for문
        for(int[] cols : arr1) {
            for(int data : cols) {
                System.out.println(data);
            }
        }
    }
}
