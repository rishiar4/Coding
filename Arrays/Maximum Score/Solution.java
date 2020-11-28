import java.util.*;
import java.lang.*;
import java.io.*;

public class Solution
{
	public static void main (String[] args) throws java.lang.Exception
	{
		// your code goes here
		Scanner scn = new Scanner(System.in);
		int t = scn.nextInt();
		for( int T = 0; T < t; T++ ){
		    int n = scn.nextInt();
		    int[][] mat = new int[n][n];
		    for( int i = 0; i < n; i++ ){
		        for( int j = 0; j < n; j++ ){
		            mat[i][j] = scn.nextInt();
		        }
		    }
		    int total = 0;
		    for( int i = 0; i < n; i++ ){
		    int rMax = -(int)1e9;
		        for( int j = 0; j < n; j++ ){
		            rMax = Math.max( rMax, mat[i][j] );
		        }
		        total += rMax;
		    }
		    System.out.println( total );
		}
	}
}
