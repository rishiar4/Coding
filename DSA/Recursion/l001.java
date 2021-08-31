import java.util.ArrayList;
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

    public static void arrayDisplay( int[] arr, int idx){
        if( idx == arr.length ) return;

        System.out.print( arr[idx] + " ");
        arrayDisplay( arr, idx + 1);
    }

    public static void arrayReverseDisplay( int[] arr, int idx){
        if( idx == arr.length ) return;

        arrayReverseDisplay( arr, idx + 1);
        System.out.print( arr[idx] + " ");
    }

    public static int maximum( int[] arr, int idx){

        if( idx == arr.length ) return -(int)1e8;

        int max = maximum( arr, idx + 1);
        return Math.max( arr[idx], max);
    }

    public static int minimum( int[] arr, int idx) {
        if ( idx == arr.length ) return (int)1e8;

        int min = minimum( arr, idx + 1);
        return Math.min( arr[idx], min);     
    }

    public static boolean find( int[] arr, int idx, int target){
        if( arr.length == idx ) return false;

        if( arr[idx] == target ) return true;

        return find( arr, idx + 1, target );
    }

    public static int firstIndex( int[] arr, int idx, int target){
        if( arr.length == idx) return -1;

        if( arr[idx] == target ) return idx;

        return firstIndex( arr, idx + 1, target);
    }

    public static int lastIndex( int[] arr, int idx, int target ){
        if( idx == arr.length ) return -1;

        int ans = lastIndex( arr, idx + 1, target);

        if( ans != -1 )
            return ans;

        if( arr[idx] == target )
            return idx;
        return -1;
    }

    public static int[] allIndex( int[] arr, int idx, int target, int count){
        if( idx == arr.length ){
            int[] base = new int[count];
            return base;
        }

        if( arr[idx] == target ){
            count++;
        } 
        int[] ans = allIndex( arr, idx + 1, target, count);
        if( arr[idx] == target){
            ans[count-1] = idx;
        }

        return ans;
    }


    public static void set1(){
        // printIncreasing(1, 10);
        // printDecreasing(1, 10);
        // printIncreasingDecreasing(1, 10);
        // printOddEven(1,10);
        // System.out.println( fact(4) );
        // System.out.println( power(2,5) );
        // System.out.println( powerBtr(2,5) );
        int[] arr = { 45, 86, 93, 25, 100, 86, 45, 93};
        // arrayDisplay( arr, 0);
        // arrayReverseDisplay( arr, 0);
        // System.out.println( maximum( arr, 0) ) ;
        // System.out.println( minimum( arr, 0) );
        // System.out.println( find( arr, 0, 101 ) );
        // System.out.println( firstIndex(arr, 0, 45));
        // System.out.println( lastIndex(arr, 0, 86) );
        int[] ans = allIndex( arr, 0, 86, 0);
        for( int ele : ans ){
            System.out.print( ele + " ");
        }

    }
    
    public static ArrayList<String> subSeq( String str, int idx ){
        if( str.length() == idx ){
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> recAns = subSeq( str, idx + 1);
        ArrayList<String> myAns = new ArrayList<>();
        for( String s : recAns ){
            myAns.add(str.charAt(idx) + s); 
            myAns.add( s );
        }

        return myAns;
    }

    public static int subSeq( String str, String ans){
        if( str.length() == 0){
            System.out.println( ans );
            return 1;
        }

        int count = 0;
        count += subSeq( str.substring(1), ans);
        count += subSeq( str.substring(1), ans + str.charAt(0));

        return count;
    }

    public static void set2(){
        String str = "abc";
        // System.out.println( subSeq(str, 0) );
        System.out.println( subSeq(str, "") );
    }

    public static ArrayList<String> mazePath_HVD( int sr, int sc, int dr, int dc){
        if( sr == dr && sc == dc ){
            ArrayList<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        ArrayList<String> myAns = new ArrayList<>();
        if( sr + 1 <= dr ){
            ArrayList<String> verticalAns = mazePath_HVD( sr + 1, sc, dr, dc );
            for( String s : verticalAns ){
                myAns.add("V" + s );
            }
        }

        if( sr + 1 <= dr && sc + 1 <= dc ){
            ArrayList<String> diagonalAns = mazePath_HVD( sr + 1, sc + 1, dr, dc );
            for( String s : diagonalAns ){
                myAns.add("D" + s );
            }
        }


        if( sc + 1 <= dc ){
            ArrayList<String> horizontalAns = mazePath_HVD( sr, sc + 1, dr, dc );
            for( String s : horizontalAns ){
                myAns.add("H" + s );
            }
        }

        return myAns;
    }

    public static int mazePath_HVD( int sr, int sc, int dr, int dc,String psf){
        if( sr == dr && sc == dc){
            System.out.println( psf );
            return 1;
        }

        int count = 0;
        if( sr + 1 <= dr ){
            count += mazePath_HVD( sr + 1, sc, dr, dc, psf + "V");
        }

        if( sr + 1 <= dr && sc + 1 <= dc ){
            count += mazePath_HVD( sr + 1, sc + 1, dr, dc, psf + "D");
        }

        if( sc + 1 <= dc ){
            count += mazePath_HVD( sr, sc + 1, dr, dc, psf + "H");
        }

        return count;
    }

    public static int mazePath_HVD_Multiple( int sr, int sc, int dr, int dc, String psf){
        if( sr == dr && sc == dc){
            System.out.println( psf );
            return 1;
        }

        int count = 0;
        for( int jump = 1; jump + sr <= dr; jump++ )
            count += mazePath_HVD_Multiple( sr + jump, sc, dr, dc, psf + "V" + jump);

        for( int jump = 1; jump + sr <= dr && jump + sc <= dc; jump++ )
            count += mazePath_HVD_Multiple( sr + jump, sc + jump, dr, dc, psf + "D" + jump);
        
        for( int jump = 1; jump + sc <= dc; jump++ )
            count += mazePath_HVD_Multiple( sr, sc + jump, dr, dc, psf + "H" + jump);

        return count;
    }

    public static int mazePath_HVD( int sr, int sc, int dr, int dc, int[][] dir, String[] dirS, String psf){
        if( sr == dr && sc == dc){
            System.out.println( psf );
            return 1;
        }

        int count = 0;

        for( int d = 0; d < dir.length; d++){
            int x = sr + dir[d][0];
            int y = sc + dir[d][1];
        
            if( x >= 0 && x <= dr && y >= 0 && y <= dc){
                count += mazePath_HVD( x, y, dr, dc, dir, dirS, psf + dirS[d] );        
            }
        }

        return count;

    }




    public static void set3(){
        int n = 3, m = 3;
        int sr = 0, sc = 0;
        // System.out.println( mazePath_HVD( sr, sc, n, m) );
        // System.out.println( mazePath_HVD(sr, sc, n, m, "") );
        // System.out.println( mazePath_HVD_Multiple( sr, sc, n, m, "") );
        int[][] dir = { {0,1}, {1,1}, {1,0} };
        String[] dirS = { "V", "D", "H"};
        // System.out.println( mazePath_HVD( sr, sc, n, m, dir, dirS, "") );
        // System.out.println( mazePath_HVD_Multiple( sr, sc, n, m, dir, dirS, "") );
    }

    public static void main( String[] args ){
        // set1();
        // set2();
        set3();
    }
}