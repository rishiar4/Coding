public class Solution{
    public static void showUpperDiagonals( int[][] arr ){
        int n = arr.length;
        for( int gap = 0; gap < n; gap++ ){
            for( int i = 0,j = gap; j < n; j++, i++ ){
                System.out.print( arr[i][j] + " ");
            }
            System.out.println();
        }
    }

    public static void showLowerDiagonals( int[][] arr ){
        int n = arr.length;
        for( int gap = 0; gap < n; gap++ ){
            for( int i = gap, j = 0; i < n; j++, i++ ){
                System.out.print( arr[i][j] + " ");
            }
            System.out.println();
        }
    }
    public static void main(String[] args) {
        int n = 5;
        int[][] arr = new int[n][n];
        for( int i = 0; i < n*n; i++ ){
            int r = i / n;
            int c = i % n;
            arr[r][c] = i;
        }

        for( int i = 0; i < n; i++ ){
            for( int j = 0; j < n; j++ ){
                System.out.print( arr[i][j] + " ");
            }
            System.out.println();
        }

        // showUpperDiagonals( arr );
        showLowerDiagonals( arr );

    }
}