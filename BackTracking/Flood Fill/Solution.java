import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) throws Exception {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int m = scn.nextInt();

        int[][] maze = new int[n][m];
        for (int i = 0; i < maze.length; i++) {
            for (int j = 0; j < maze[0].length; j++) {
                maze[i][j] = scn.nextInt();
            }
        }

        floodfill(maze, 0, 0, "", new boolean[maze.length][maze[0].length]);
    }
    
    static int[][] dir = { { -1, 0 }, { 0, -1 }, { 1, 0 }, { 0, 1  } };
    static String[] dirS = { "t", "l", "d", "r" };
    public static void floodfill(int[][] maze, int row, int col, String psf, boolean[][] visited ) {
        if( row == maze.length - 1 && col == maze[0].length - 1  )
        {
            visited[row][col] = true;
            System.out.println( psf );
            visited[row][col] = false;
            return;
        }
        
        
        visited[row][col] = true;
        
        for( int i = 0; i < dir.length; i++ )
        {
            int r = row + dir[i][0];
            int c = col + dir[i][1];
            
            if( r >= 0 && r < maze.length && c >= 0 && c < maze[0].length && maze[r][c] == 0 &&  visited[r][c] == false )
            {
                floodfill( maze, r, c, psf + dirS[i], visited );
            }
        }
        
        visited[row][col] = false;
        
    }
}