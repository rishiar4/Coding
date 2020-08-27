class Solution {
    public char findTheDifference(String s, String t) {
        HashMap<Character,Integer> hm = new HashMap<>();
        
        if(s.length() == 0 )
        {
            return t.charAt(0);
        }
        for( int i = 0; i < t.length(); i++ )
        {
            char ch = t.charAt( i );
            if( hm.containsKey( ch ) )
            {
                hm.put( ch, hm.get( ch ) + 1 );
            }
            else
            {
                hm.put( ch,1 );
            }
        }
        
        for( int i = 0; i < s.length(); i++ )
        {
            char ch = s.charAt( i );
            if( hm.containsKey( ch ) == true )
            {
                int val = hm.get( ch );
                if( val - 1 == 0 )
                {
                    hm.remove(ch);
                }
                else
                {
                    hm.put( ch, val - 1 );
                }
            }
        }
        char ans = s.charAt(0);
        for( char ch : hm.keySet() )
        {
            ans = ch;
        }
        return ans;
    }
}