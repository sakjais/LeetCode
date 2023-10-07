class Solution {
    public String longestPalindrome(String s) {
        int len = s.length();
        boolean[][] subProblems = new boolean[len][len];
        String longest = s.substring(0, 1);
        int lLen = 1;
        //base case, size is 0 and 1
        for(int i = 0; i < len; ++ i) {
            subProblems[i][i] = true;
            if((i + 1) < len) {
                if(s.charAt(i) == s.charAt(i + 1)) {
                    subProblems[i][i + 1] = true;
                    if(lLen < 2) {
                        longest = s.substring(i, i + 2);
                        lLen = 2;
                    }
                }
                else {
                    subProblems[i][i + 1] = false;
                }
            }
        }
        for(int size = 2; size < len; ++ size) {
            for(int i = 0; i < len; ++ i) {
                if((i + size) >= len) {
                    break;
                }
                if(subProblems[i + 1][i + size - 1]) {
                    if(s.charAt(i) == s.charAt(i + size)) {
                        subProblems[i][i + size] = true;
                        if(lLen < (size + 1)) {
                            longest = s.substring(i, i + size + 1);
                            lLen = size + 1;
                        }
                    }
                    else {
                        subProblems[i][i + size] = false;
                    }
                }
                else {
                    subProblems[i][i + size] = false;
                }
            }

        }
        return longest;
    }
}