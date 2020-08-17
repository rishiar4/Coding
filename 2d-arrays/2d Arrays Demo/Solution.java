import java.io.*;
import java.util.*;

public class Solution{

public static void main(String[] args) throws Exception {
    Scanner scn = new Scanner(System.in);
    int n = scn.nextInt();
    int m = scn.nextInt();
    int[][] mat = new int[ n ][ m ];

    for( int i = 0; i < mat.length; i++  )
    {
        for( int j = 0; j < mat[i].length; j++ )
        {
            mat[ i ][ j ] = scn.nextInt();
        }
    }

    display( mat );
    
 }

 public static void display( int[][] mat )
 {
     for( int i = 0; i < mat.length; i++ )
     {
         for( int j = 0; j < mat[i].length; j++ )
         {
             System.out.print( mat[ i ][ j ] + " ");
         }
         System.out.println();
     }
 }

}