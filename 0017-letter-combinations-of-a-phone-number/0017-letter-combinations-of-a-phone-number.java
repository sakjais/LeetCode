class Solution {
    public List<String> letterCombinations(String digits) {
       List<String> res = new ArrayList<>();
       List<Character> curChrSeq = new ArrayList<>();
       findCombs(digits, 0, res, curChrSeq);
       return res;     
    }
    private String []dToLMap = {"abc", "def", "ghi", "jkl", "mno", "pqrs", "tuv", "wxyz"};
    private void findCombs(String digits, int startIndx, List<String> res, List<Character>  curChrSeq){
        int sz = digits.length();
        if(startIndx == sz){
            StringBuilder comb = new StringBuilder();
            for(var chr : curChrSeq){
                comb.append(chr);
            }
            if(comb.length() > 0)
             res.add(comb.toString());
            return;
        }
        String optns = dToLMap[digits.charAt(startIndx) - '2'];
        sz = optns.length();
        for(int indx = 0; indx<sz; indx++){
            curChrSeq.add(optns.charAt(indx));
            findCombs(digits, startIndx+1, res, curChrSeq);
            curChrSeq.remove(curChrSeq.size()-1);
        }
    }
}