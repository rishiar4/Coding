import java.util.*;

public class pattern2{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        int n = scn.nextInt();

        int nstars = n;
        for(int i = 0; i < n; i++ )
        {
            for(int j = nstars; j > 0; j--)
            {
                System.out.print("* \t");
            }
            nstars--;
            System.out.println();
        }
    }
}