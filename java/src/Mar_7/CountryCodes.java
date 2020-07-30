package Mar_7;

public class CountryCodes {
    public static void main(String[] args) {
        int arr[][] = {{5, 4, 4}};
//        A[0][0] =     A[0][1] = 4    A[0][2] = 4
//        A[1][0] = 4    A[1][1] = 3    A[1][2] = 4
//        A[2][0] = 3    A[2][1] = 2    A[2][2] = 4
//        A[3][0] = 2    A[3][1] = 2    A[3][2] = 2
//        A[4][0] = 3    A[4][1] = 3    A[4][2] = 4
//        A[5][0] = 1    A[5][1] = 4    A[5][2] = 4
//        A[6][0] = 4    A[6][1] = 1    A[6][2] = 1

        int result = findCountries(arr);
        System.out.println(result);
    }

    private static int findCountries(int[][] arr) {
        if(arr==null)
            return 0;
        boolean[][] marked = new boolean[arr.length][arr[0].length];
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[0].length; j++) {
                if (!marked[i][j]) {
                    dfs(arr, marked, i, j, arr[i][j]);
                    //printMatrix(marked);

                    count++;
//                    System.out.println(count);
//                    System.out.println("======================");
//                    System.out.println();

                }
            }
        }
        return count;
    }

    private static void printMatrix(boolean[][] marked) {
        for (int i = 0; i < marked.length; i++) {
            for (int j = 0; j < marked[0].length; j++) {
                System.out.print(marked[i][j] + " ");
            }
            System.out.println();


        }
    }

    private static void dfs(int[][] arr, boolean[][] marked, int i, int j, int value) {
        if (i < 0 || j < 0 || i >= arr.length || j >= arr[0].length || marked[i][j] || value != arr[i][j])
            return;
        marked[i][j] = true;
        dfs(arr, marked, i + 1, j, value);
        dfs(arr, marked, i - 1, j, value);
        dfs(arr, marked, i, j + 1, value);
        dfs(arr, marked, i, j - 1, value);

    }
}
