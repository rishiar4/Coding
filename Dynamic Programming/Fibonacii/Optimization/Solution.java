public  class Solution{
    
    public static int fib( int N, int[] dp)
    {
        int a = 0, b = 1;
        for( int n = 0; n <= N; n++ ){
        if( n <= 1 ) {
            continue;
        }

        int sum = a + b;
        a = b;
        b = sum;

     }
     return b;
    }
    
    public static void main(String[] args) {
        int n = 7;
        int[] dp = new int[n+1];
        System.out.println( fib( n, dp ) );
    }
}