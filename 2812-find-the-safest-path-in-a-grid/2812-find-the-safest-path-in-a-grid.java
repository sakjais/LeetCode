class Solution {
    public int maximumSafenessFactor(List<List<Integer>> grd) {
        int rw = grd.size(), cw = rw;
        int grid[][] = new int[rw][cw];
        for(int r  = 0; r<rw; r++){
            List<Integer> cols = grd.get(r);
            for(int c = 0; c<cw; c++){
                grid[r][c] = cols.get(c);
            }
        }
        int  dG[][] = new int [rw][cw];
        for(var d : dG){
            Arrays.fill(d, Integer.MAX_VALUE);
        }
        if(grid[0][0] == 1)dG[0][0] = 0;
        // up to bottom
        for(int r = 0; r < rw; r++){
            for(int c = 0; c < cw; c++){
                if(r == 0 && c== 0)continue;
                if(grid[r][c] == 1){
                    dG[r][c] = 0;
                    continue;
                }
                int minD = Math.min(r > 0 ? dG[r-1][c] : Integer.MAX_VALUE, c > 0 ? dG[r][c-1] : Integer.MAX_VALUE);
                if(minD != Integer.MAX_VALUE)
                 dG[r][c] = minD + 1; 
            }
        }
        if(grid[rw-1][cw-1] == 1)dG[rw-1][cw - 1] = 0;
        //down to up
        for(int r = rw-1; r > -1; r--){
            for(int c = cw - 1; c > -1; c--){
                if(r == rw-1 && c == cw - 1){
                    continue;
                }
                if(grid[r][c] == 1){
                    dG[r][c] = 0;
                    continue;
                }
                int minD = Math.min((r < rw-1) ?  dG[r+1][c] : Integer.MAX_VALUE, (c < cw-1) ? dG[r][c+1] : Integer.MAX_VALUE);
                if(minD != Integer.MAX_VALUE)
                    dG[r][c] = Math.min(dG[r][c], 1 + minD);
            }
        }
        return findSf(dG, rw, cw);      
    }
    private int dirs[][] = {{1, 0}, {0, 1}, {-1, 0}, {0, -1}};
    private int findSf(int[][] dG, int r, int c){
        int left = 0, right = 1000000000;
        int maxSafe = 0;
        while(left <= right){
           int testSf = left + (right - left)/2;
           if(test(dG, testSf)){
               maxSafe = testSf;
               left = testSf + 1;
           }else{
               right = testSf - 1;
           }
        }
        return maxSafe; 
    }
    private boolean test(int [][]dG, int testSf) 
    {
        int sz = dG.length;
        Deque<Pair<Integer, Integer>>que = new ArrayDeque<>();
        boolean visited[][] = new boolean[sz][sz];
        if (dG[0][0] < testSf) return false;
        que.offerLast(new Pair<Integer, Integer>(0, 0));
        visited[0][0] = true;
        while(!que.isEmpty())
        {
            var cords = que.pollFirst();
            int currRow = cords.getKey(), currCol = cords.getValue();
            if (currRow == sz - 1 && currCol == sz - 1) return true;
            for (var dir : dirs)
            {
                int newRow = currRow + dir[0];
                int newCol = currCol + dir[1];
                if (checkCord(visited, newRow, newCol))
                {
                    if (dG[newRow][newCol] < testSf) continue;
                    visited[newRow][newCol] = true;
                    que.offerLast(new Pair<Integer, Integer>(newRow, newCol));
                }
            }
        }
        return false;
    }
    private boolean checkCord(boolean [][]visited, int r, int c)
    {
        int cols = visited[0].length, rows = cols;
        return !(r < 0 || c < 0 || r == rows ||  c == cols || visited[r][c] == true);
    }
    
}