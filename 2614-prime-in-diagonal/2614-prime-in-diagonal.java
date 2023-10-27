class Solution {
    public static boolean is_prime(double n){
        if(n<2) { return false; }
        for (int i=2; i<=Math.sqrt(n); i++){
            if(n%i==0){
                return false;
            }
        }
        return true;
    }
    public int diagonalPrime(int[][] nums) {
        int n = nums.length,ele=0;
        List<Integer> list = new ArrayList<>();

        for(int i=0; i<n; i++){
            ele = nums[i][i];
            is_prime(ele);
            if(is_prime(ele)==true){
                list.add(ele);
            }
        }
        int row =0 , col =n-1;
        while(row<n && 0<=col){
            if(row==col){
            ele=ele;
            }
            else{
                ele = nums[row][col];
                is_prime(ele);
                if(is_prime(ele)==true){
                    list.add(ele);
                }
            }
            row++;
            col--;
        }
        list.add(0);
        Collections.sort(list);
        return list.get(list.size()-1);

        
    }
}