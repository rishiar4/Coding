class Solution {
    public List<String> llc(String digits)
    {
        if( digits.length() == 0 )
        {
            List<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }
        
        int nums = digits.charAt(0) - '0';
        String rDigits = digits.substring(1);
        String word = words[nums];
        
        List<String> recAns = llc( rDigits );
        List<String> myAns = new ArrayList<>();
        for( int i = 0 ; i < recAns.size(); i++ )
        {
            for( int j = 0; j < word.length(); j++ )
            {
                myAns.add( word.charAt(j) + recAns.get(i)  );
            }
        }
        return myAns;
    }
    String words[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations(String digits) {
        if( digits.length() == 0 )
        {
            return new ArrayList<>();
        }
        else
            return llc(digits);
    }
}