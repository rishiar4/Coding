public  class Solution{
    
    public static int fib( int n )
    {
        if( n <= 1 ) return n;

        int a = fib( n - 1 );
        int b = fib( n - 2 );

        return a + b; 
    }
    
    public static void main(String[] args) {
        int n = 7;
        System.out.println( fib( n ) );
    }
}