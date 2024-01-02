class Solution {
    public boolean isMatch(String data, String pattern) {
         boolean dp[][] = new boolean[data.length() + 1][pattern.length() +1];
        dp[0][0] = true;
        for (int i = 1; i <= data.length(); i++) {
            dp[i][0] = false;
        }
        for (int i = 1; i <= pattern.length(); i++) {
            dp[0][i] = false;
        }

        for (int i = 1; i <= pattern.length(); i++) {
            if(pattern.charAt(i-1) != '*')
                break;
            dp[0][i] = true;
        }


        for (int i = 1; i <= data.length(); i++) {
            for (int j = 1; j <= pattern.length(); j++) {
                if(pattern.charAt(j-1) =='?'){
                    dp[i][j] = dp[i-1][j-1];
                }else if(pattern.charAt(j-1) == '*'){
                    dp[i][j] = dp[i-1][j] || dp[i][j-1];
                }else{
                    dp[i][j] = dp[i-1][j-1] && data.charAt(i-1) == pattern.charAt(j-1);
                }
            }
        }
        return dp[data.length()][pattern.length()];
    }
}