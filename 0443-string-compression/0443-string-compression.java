class Solution {
    public int compress(char[] chars) {
        StringBuilder sb = new StringBuilder("");
        int n = chars.length;
        for(int i=0; i<chars.length; i++)
        {
            Integer count=1;
            while(i<n-1 && chars[i] == chars[i+1])
            {
                count++;
                i++;
            }
            sb.append(chars[i]);
            if(count>1){
                sb.append(Integer.toString(count));
            }
        }
        char[] compressed = sb.toString().toCharArray();
        System.arraycopy(compressed, 0, chars, 0, compressed.length);
        return compressed.length;
    }
}