import java.util.ArrayList;
public class l001{

    public static void printIncreasing( int idx, int n ){
        if( idx == n + 1 ) return;

        System.out.print( idx + " ");
        printIncreasing( idx + 1, n );
    }

    public static void printDecreasing( int idx, int n ){
        if( idx == n + 1 ) return;

        printDecreasing( idx + 1, n );
        System.out.print( idx + " ");
    }

    public static void printOddEven( int idx, int n ){
        if( idx == n + 1 ) return;

        if( idx % 2 != 0 ) System.out.print( idx + " ");
        printOddEven( idx + 1, n );
        if( idx % 2 == 0 ) System.out.print( idx + " ");

    }

    public static int fact( int n ){
        return ( n == 0 ) ? 1 : n *  fact( n - 1 );
    }

    public static int pow( int n, int x ){
        return x == 0 ? 1 : pow( n, x - 1 ) * n;
    }

    public static int powBtr( int n, int x ){
        if( x == 0 ) return 1;

        int ans = powBtr( n, x /2 );
        ans *= ans;
        return ( x % 2 != 0 )?  n * ans : ans;
    }


    public static void set1(){
        int n = 10;
        // printIncreasing( 0, n );
        // printDecreasing( 0, n );
        // printOddEven( 0, n );
        // System.out.println( fact( n ) );
        int x = 3;
        // System.out.println( pow( n, x ) );
        System.out.println( powBtr( n, x ) );
    }

    public static void display( int[] arr, int idx ){
        if( idx == arr.length ) return;

        System.out.print( arr[idx] + " ");
        display( arr, idx + 1 );
    }

    public static void displayR( int[] arr, int idx ){
        if( idx == arr.length ) return;

        displayR( arr, idx + 1 );
        System.out.print( arr[idx] + " ");
    }

    public static int minimum( int[] arr, int idx ){
        if( idx == arr.length ) return (int)1e9;
        return Math.min( arr[idx], minimum( arr, idx + 1 ) );
    }

    public static int maximum( int[] arr, int idx ){
        if( idx == arr.length ) return -(int)1e9;
        return Math.max( arr[idx], maximum( arr, idx + 1 ) );
    }

    public static boolean find( int[] arr, int idx, int data ){
        if( idx == arr.length ) return false;

        if( arr[idx] == data ) return true;
        return find( arr, idx + 1, data );
    }

    public static int firstIndex( int[] arr, int idx, int data ){
        if( idx == arr.length ) return -1;
        if( arr[ idx ] == data  ) return idx;
        return firstIndex( arr, idx + 1, data );
    }

    public static int lastIndex( int[] arr, int idx, int data ){
        if( idx == arr.length ) return -1;
        int ans = lastIndex( arr, idx + 1, data );
        if( ans != -1 ) return ans;

        return arr[idx] == data ? idx : -1;
    }

    public static int[] allIndex( int[] arr, int idx, int data, int csf ){
        if( idx == arr.length ){
            int[] ans = new int[ csf ];
            return ans;
        }

        if( arr[idx] == data ) csf++;

        int[] ans = allIndex( arr, idx + 1, data, csf );

        if( arr[idx] == data ) ans[ csf - 1 ] = idx;

        return ans;
    }

    public static void set2(){
        int[] arr = { 1, 52, 17, 25, 63, 96, 21, 78, 25, -96, 25 };
        // display( arr, 0 );
        // displayR( arr, 0 );
        // System.out.println( minimum( arr, 0 ) );
        // System.out.println( maximum( arr, 0 ) );
        // System.out.println( find( arr, 0, -25 ) );
        // System.out.println( firstIndex( arr, 0, 25 ) );
        // System.out.println( lastIndex( arr, 0, 25 ) );
        // int[] ans = allIndex( arr, 0, 25, 0 );
        // for( int ele : ans ) System.out.print( ele + " ");
    }

    public static ArrayList<String> subsequence( String str, int idx ){
        if( idx == str.length() ){
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        char ch = str.charAt( idx );
        ArrayList<String> recAns = subsequence( str, idx + 1 );

        ArrayList<String> myAns = new ArrayList<>();
        for( String s : recAns ){
            myAns.add( s );
            myAns.add( ch + s );
        }

        return myAns;
    }

    public static int subsequence( String str, String ans ){
        if( str.length() == 0 ){
            System.out.println( ans );
            return 1;
        }

        int count = 0;
        count += subsequence( str.substring(1), ans );
        count += subsequence( str.substring(1), ans + str.charAt(0) );

        return count;
    }

    public static void set3(){
        // System.out.println( subsequence("abc", 0 ) );
        subsequence( "abc", "" );
        
    }

    public static void solve(){
        // set1();
        // set2();
        set3();
    }

    public static void main(String[] args) {
        solve();
    }
}