class Solution {
    public int myAtoi(String s) 
    {
        //trim the string to avoid leading extra spaces
        s=s.trim();
        if(s.isEmpty()) return 0;

        int ans=0,i=0;
        boolean neg=s.charAt(0) == '-';
        boolean pos=s.charAt(0) == '+';
        if(neg || pos) i++;

        //iterate over string.
        while(i<s.length() && Character.isDigit(s.charAt(i)))
        {
            int digit = s.charAt(i) - '0'; //convert char to int

            //check for overflow condition
            if(ans>Integer.MAX_VALUE / 10 || (ans==Integer.MAX_VALUE / 10 && digit>Integer.MAX_VALUE %10))
            {
                return neg?Integer.MIN_VALUE:Integer.MAX_VALUE;
            }

            ans=ans*10 + digit;
            i++;
        }

        return neg? -ans:ans;
        
    }
}