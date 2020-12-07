class Solution {
    public String minWindow(String s, String t) {
        int ns = s.length();
        int nt = t.length();

        int req = nt, si = 0, ei = 0, len = (int)1e8, head = 0;
        int[] freq = new int[128];

        for( int i = 0; i < nt; i++ ) freq[t.charAt(i)]++;

        while( ei < ns ){
            if( freq[s.charAt(ei++)]-- > 0 ) req--;

            while( req == 0 ){
                if( ei - si < len ) len = ei - ( head = si );
                if( freq[s.charAt(si++)]++ == 0 ) req++;
            }
        }
        
        return len == (int)1e8 ? "" : s.substring( head, head + len) ;
    }
}