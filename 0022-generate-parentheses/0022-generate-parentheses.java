class Solution {
    List<String> result = new ArrayList<>();
    public List<String> generateParenthesis(int n) {
        backtrack(n, new StringBuilder(), 0);
        return result;
    }

    private void backtrack(int n, StringBuilder sb, int open){
        // Invalid states:
        // 1.) When closed brackets > open brackets
        // 2.) when the result length is greater than expected results length.
        if(open < 0 || sb.length() > 2*n)
            return;

        if(sb.length() == 2*n && open==0){
            result.add(sb.toString());
            return;
        }       

        backtrack(n, sb.append("("), open+1);
        sb.deleteCharAt(sb.length()-1);
        backtrack(n, sb.append(")"), open-1);
        sb.deleteCharAt(sb.length()-1);
    }
}