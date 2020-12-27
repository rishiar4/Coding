class Solution {
    String words[] = {"","","abc","def","ghi","jkl","mno","pqrs","tuv","wxyz"};
    public List<String> letterCombinations( String digits, int idx ){
        if( idx == digits.length() ){
            List<String> baseAns = new ArrayList<>();
            baseAns.add("");
            return baseAns;
        }

        int nums = digits.charAt(idx) - '0';
        String word = words[nums];
        
        List<String> recAns = letterCombinations( digits, idx + 1 );
        List<String> myAns = new ArrayList<>();
        for( String s : recAns ){
            for( int i = 0; i < word.length(); i++ ){
                myAns.add( word.charAt(i) + s );
            }
        }
        return myAns;
    }
    public List<String> letterCombinations(String digits) {
        if( digits.length() == 0 ) return new ArrayList<>();
        return letterCombinations( digits, 0 );
    }
}