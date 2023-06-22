class Solution {
    public double averageWaitingTime(int[][] customers) {
        int n = customers.length;
        long chefTime = customers[0][1] + customers[0][0];
        long waitTime = customers[0][1];

        for(int i=1; i<n; i++){
            int arrival = customers[i][0];
            int timeRequired = customers[i][1];
            chefTime = Math.max(chefTime, arrival);
            chefTime += timeRequired;
            waitTime += chefTime - arrival;
        }
        return (double) waitTime/n;
    }
}