class Solution {
    public int[] rowAndMaximumOnes(int[][] arr) {
        int ans = 0;
        int ind = 0;
        int n = arr.length;
        int m = arr[0].length;
        int[] res = new int[2];
        for(int i = 0;i<n;i++){
            int count=0;
            for(int j = 0;j<m;j++){
                if(arr[i][j]==1){
                    count+=1;
                }
            }
            if(ans<count){
                ans=count;
                ind = i;
                res[0] = ind;
                res[1] = count;
            }
        }
        return res;
    }
}