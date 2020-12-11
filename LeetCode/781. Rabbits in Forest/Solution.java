class Solution {
        public int numRabbits(int[] answers) {
            if( answers.length == 0 ) return 0;

            HashMap<Integer,Integer> hm = new HashMap<>();

            int ans = 0;
            for( int ele : answers ){
                if( !hm.containsKey( ele ) ){
                    hm.put( ele, 1 );
                    ans += (ele + 1);
                }else{
                    hm.put( ele, hm.get(ele) + 1 );
                }

                if( hm.get(ele) == ele + 1 ) hm.remove( ele );
            }
            return ans;
        }
    }