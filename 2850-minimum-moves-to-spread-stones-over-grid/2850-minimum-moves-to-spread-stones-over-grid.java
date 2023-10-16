class Solution {
    private int minMovs = -1;
    public int minimumMoves(int[][] grid) {
        minMovs = Integer.MAX_VALUE;
        int rows = grid.length, cols = grid[0].length;
        List<Pair<Integer, Integer>> zeros = new ArrayList<>(), ones = new ArrayList<>();
        for(int r = 0; r<rows; r++){
            for(int c = 0; c < cols; c++){
                if(grid[r][c] > 1){
                    ones.add(new Pair<Integer, Integer>(r, c));
                }else if(grid[r][c] == 0){
                    zeros.add(new Pair<Integer, Integer>(r, c));
                }
            }
        }
        findMoves(zeros, ones, 0, 0, grid);
        return minMovs;
    }
    private void findMoves(List<Pair<Integer, Integer>> zeros, List<Pair<Integer, Integer>>  ones, int startIndx, int mov, int[][] grid){
        int sz = zeros.size(), szO = ones.size();
        if(sz == startIndx){
            minMovs = Math.min(minMovs, mov);
            return;
        }
        var pr1 = zeros.get(startIndx);
        for(int indx = 0; indx < szO; indx++){
            var pr = ones.get(indx);
            if(grid[pr.getKey()][pr.getValue()] > 1){
                grid[pr.getKey()][pr.getValue()]--;
                findMoves(zeros, ones, startIndx+1, mov + Math.abs(pr1.getKey() - pr.getKey()) + Math.abs(pr.getValue() - pr1.getValue()), grid);
                grid[pr.getKey()][pr.getValue()]++;
            }
        }
    }
}