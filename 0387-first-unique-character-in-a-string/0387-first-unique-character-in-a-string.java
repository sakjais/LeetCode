class Solution {
    public int firstUniqChar(String s) {
        int m=0;
        for(int i : s.toCharArray()) {
            
            if(s.indexOf(i) == s.lastIndexOf(i)){
                return m;
            }m++;
        }return -1;
    }
}