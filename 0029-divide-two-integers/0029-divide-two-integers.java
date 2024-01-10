class Solution {

    public int divide(int dnd, int div) {
        
        if (dnd == Integer.MIN_VALUE && div == -1) 
            return Integer.MAX_VALUE; // Handle overflow case
        
        int q=0;
        int isN=1;
        if((dnd<0 && div>0) || (dnd>0 && div<0))
            isN=-1;
        
        dnd=(dnd<0)?-dnd:dnd;
        div=(div<0)?-div:div;

        while(dnd - div >= 0){
            int tempDiv=div, mul=1;
            while(dnd - (tempDiv<<1) >= 0){
                tempDiv <<= 1;
                mul <<= 1;
            }
            dnd-=tempDiv;
            q+=mul;
        }

        return q*isN;
    }   
}