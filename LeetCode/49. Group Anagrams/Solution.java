
class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        HashMap<String,ArrayList<String>> hm = new HashMap<>();

        for( String s : strs )
        {
            int[] freq = new int[26];
            for( int i = 0; i < s.length(); i++ )
            {
                freq[ s.charAt(i) -'a' ]++;
            }
            StringBuilder sb = new StringBuilder();
            for( int i = 0; i < 26; i++ )
            {
                if( freq[i] > 0 )
                {
                    sb.append( (char)(i+'a') );
                    sb.append( freq[i] );
                }
            }

            String RLES = sb.toString();
            hm.putIfAbsent( RLES, new ArrayList<>());
            hm.get(RLES).add(s);
        }
        List<List<String>> ans = new ArrayList<>();
        for( String key : hm.keySet() )
        {
            ans.add( hm.get(key));
        }
        return ans;
    }
}