class Solution {
    public int[][] generateMatrix(int n) {
        int [][] a = new int[n][n];
        int startRow=0,startCol=0,endRow=n-1,endCol=n-1,v=1;
        while(startRow<=endRow||startCol<=endCol){
         if(startCol<=endCol){
             for(int i=startRow;i<=endRow;i++)
                a[startCol][i]=v++;
             startCol++;
         }
         if(startRow<=endRow){
             for(int i=startCol;i<=endCol;i++)
                 a[i][endRow]=v++;
             endRow--;
         }
         if(startCol<=endCol){
             for(int i=endRow;i>=startRow;i--)
             a[endCol][i]=v++;
             endCol--;
         }
         if(startCol<=endCol){
             for(int i=endCol;i>=startCol;i--)
             a[i][startRow]=v++;
         }
         startRow++;
        }
        return a;
    }
}
