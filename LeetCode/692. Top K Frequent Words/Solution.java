class Solution {
    public List<String> topKFrequent(String[] words, int k) {
        HashMap<String,Integer> hm = new HashMap<>();
        List<String> ll = new ArrayList<>();
        for( String s : words )
        {
            if( hm.containsKey(s) )
            {
                hm.put( s, hm.get(s) + 1 );
            }
            else
            {
                hm.put(s,1);
            }
        }
        
        PriorityQueue<String> pq = new PriorityQueue<>((a,b)->{
            if( hm.get(a) == hm.get(b) )
                return b.compareTo(a);
            else
                return  hm.get(a) - hm.get(b);
        });
        
        for( String key: hm.keySet() )
        {
           pq.add(key);
           if(pq.size() > k )
               pq.remove();
        }
        
        while(pq.size()!=0)
            ll.add(pq.remove());
        

        Collections.reverse(ll);
        // System.out.println(ll);
        return ll;
    }
}