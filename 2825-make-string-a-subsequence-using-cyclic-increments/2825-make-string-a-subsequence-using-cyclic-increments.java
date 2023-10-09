class Solution {
    public boolean canMakeSubsequence(String str1, String str2) {
        char[] str1_arr= str1.toCharArray();
        char[] str2_arr= str2.toCharArray();
        boolean flag=false;
        int idx=0;
        int co=0;
        for(char c: str2_arr) {
            boolean f=false;
            for(int i=idx;i<str1_arr.length;i++) {
                 if((int)c ==(int)str1_arr[i] || (int)c == ((int)str1_arr[i]+1-97) %26+97) {
                    idx=i+1;
                     co++;
                     f=true;
                }
                if(f==true) {
                    break;
                }
                
            }
            if(co==str2_arr.length) {
                    flag=true;
                    break;
                }
        }
        if (flag) {
            return true;
        } 
        return false;
  }
}