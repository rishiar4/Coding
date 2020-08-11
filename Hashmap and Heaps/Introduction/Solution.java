import java.util.*;

public class Solution{
    public static void main(String[] args) {
        Scanner scn = new Scanner(System.in);
        
        HashMap<String,Integer> hm =  new HashMap<>();

        //Putting
        hm.put("India",135);
        hm.put("China",200);
        hm.put("US", 120);
        hm.put("Uthopia",10);

        System.out.println( hm );

        hm.put("Nigeria", 50 );
        //Updating
        hm.put("India",140);

        System.out.println( hm );

        //Get

        System.out.println( hm.get("India"));
        System.out.println( hm.get("Pak"));

        // containsKey

        System.out.println( hm.containsKey("India") );
        System.out.println( hm.containsKey("Pak") );

        Set<String> keys = hm.keySet();
        System.out.println( keys );

        for( String key : hm.keySet() )
        {
            System.out.println(key +" = " + hm.get(key));
        }

    }
}