public class l001{
    public static void printIncreasing(int a, int b){
        if( a > b ){
            return;
        }
        System.out.print( a + "  ");
        printIncreasing( a + 1, b);
    }

    public static void printDecreasing( int a, int b ){
        if( a > b )
            return;
        printDecreasing( a + 1, b);
        System.out.print( a + " ");
    }

    public static void printIncreasingDecreasing( int a, int b){
        if( a > b ) return;

        System.out.print( a + " ");
        printIncreasingDecreasing( a + 1, b);
        System.out.print( a + " ");
    }
    
    public static void printOddEven( int a, int b){
        if( a > b ) return;

        if( a % 2 != 0 ) System.out.print( a + " ");
        printOddEven( a + 1, b);
        if( a % 2 == 0 ) System.out.print( a + " ");
    }

    public static int fact(int n){
        return n == 0 ? 1 : fact( n - 1 ) * n;
    }

    public static int power( int a, int b){
        return b == 0 ? 1 : a * power( a, b - 1);
    }

    public static int powerBtr( int a, int b){
        if( b == 0 )
            return 1;
        int smallAns = powerBtr( a, b/2);
        smallAns *= smallAns;

        return b % 2 != 0 ? smallAns * a : smallAns;
        
    }


    public static void set1(){
        // printIncreasing(1, 10);
        // printDecreasing(1, 10);
        // printIncreasingDecreasing(1, 10);
        // printOddEven(1,10);
        // System.out.println( fact(4) );
        // System.out.println( power(2,5) );
        System.out.println( powerBtr(2,5) );
    }
    public static void main( String[] args ){
        set1();
    }
}