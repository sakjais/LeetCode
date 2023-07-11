class Solution {
    public int[][] generateMatrix(int n) {
        int [][] a = new int[n][n];
        int startRow=0,startCol=0,endRow=n-1,endCol=n-1,v=1;
        while(startCol<=endRow||startRow<=endCol){
         if(startCol<=endRow){
             for(int i=startRow;i<=endCol;i++)
                a[startCol][i]=v++;
             startCol++;
         }
         if(startRow<=endCol){
             for(int i=startCol;i<=endRow;i++)
                 a[i][endCol]=v++;
             endCol--;
         }
         if(startCol<=endRow){
             for(int i=endCol;i>=startRow;i--)
             a[endRow][i]=v++;
             endRow--;
         }
         if(startCol<=endRow){
             for(int i=endRow;i>=startCol;i--)
             a[i][startRow]=v++;
         }
         startRow++;
        }
        return a;
    }
}
