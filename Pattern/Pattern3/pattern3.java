import java.util.*;

public class pattern3{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();
        int nspaces = n-1;
        int nstars = 1;

        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < nspaces; j++ )
            {
                System.out.print("\t");
            }
            for(int j = 0; j < nstars; j++)
            {
                System.out.print("* \t");
            }
            nstars++;
            nspaces--;
            System.out.println();
        }
    }
}