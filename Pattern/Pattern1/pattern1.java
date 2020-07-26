import java.util.*;

public class pattern1{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);

        int n = scn.nextInt();
        
        int nstars = 1;
        for(int i = 0; i < n; i++)
        {
            for(int j = 0; j < nstars; j++)
            {
                System.out.print("* \t");
            }
            nstars++;
            System.out.println();
        }

    }
}