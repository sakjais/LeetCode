class Solution {
    public boolean checkStrings(String s1, String s2) {
        return f(s1, 0).equals(f(s2, 0)) && f(s1,1).equals(f(s2, 1));
    }
    String f(String s, int i) {
        char ar[]=new char[s.length()/2+(s.length()%2!=0 && i==0?1: 0)];
        for(;i<s.length(); ar[i/2]=s.charAt(i), i+=2);
        Arrays.sort(ar);
        return new String(ar);
    }
}