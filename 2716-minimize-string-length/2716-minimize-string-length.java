class Solution {
    public int minimizedStringLength(String s) {
        int len = s.length();
        int charIndex = 0;
        while(charIndex < 26) {
            int i=0;
            while(i < s.length() && s.charAt(i) != (char) ('a' + charIndex))
                i++;
            int end = i+1;
            int count = 0;
            while(end < s.length()) {
                if(s.charAt(end) == (char)('a' + charIndex))
                    count++;
                if(count == 2) {
                    len -= 2;
                    count = 0;
                }
                end++;
            }
            if(count > 0)
                len -= 1;
            charIndex++;
        }
        
        return len;
    }
}