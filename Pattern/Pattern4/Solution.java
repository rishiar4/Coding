import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nspaces = 0;
        int nstars = n;

        for(int i = 0; i < n; i++ )
        {
            for(int j = 0; j < nspaces; j++ )
            {
                System.out.print("\t");
            }
            for(int j = 0; j < nstars; j++)
            {
                System.out.print("*\t");
            }
            nspaces++;
            nstars--;
            System.out.println();
        }
    }
}