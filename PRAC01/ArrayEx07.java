public class ArrayEx07 {
    public static void main(String[] args) {
        // 3차원 배열
        // int[][][] intArr = new int[3][3][3];

        int[][][] intArr = 
        {
            {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
            },

            {
                {10, 11, 12},
                {13, 14, 15},
                {16, 17, 18}
            },

            {
                {19, 20, 21},
                {22, 23, 24},
                {25, 26, 27}
            }
        };

        
        for (int i = 0; i < intArr.length; i++) {
            for (int j = 0; j < intArr[i].length; j++) {
                for (int k = 0; k < intArr[i][j].length; k++) {
                    System.out.print(intArr[i][j][k] + "\t");
                }
            }
        }
    }
}
