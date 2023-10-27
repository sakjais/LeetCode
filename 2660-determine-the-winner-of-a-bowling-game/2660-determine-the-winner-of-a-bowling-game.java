class Solution {
    
    public int isWinner(int[] player1, int[] player2) {

        int player1Score = calculateScore(player1);
        int player2Score = calculateScore(player2);

        if (player1Score == player2Score)
            return 0;

        return player1Score > player2Score ? 1 : 2;      
    }


    public int calculateScore (int [] score) {

        int sum = 0;
        int n = score.length;

        if ( n == 1 )
            return score[0];

        if (score[0] == 10)
            sum =   score[0] + 2*score[1] ;
        else    
            sum =   score[0] + score[1];

        for (int i = 2; i < n; i++) {
            if ( score[i-1] == 10 || score[i-2] == 10 ){
                sum = sum + 2 * score[i];
            } else {
                sum += score[i]; 
            }  
        }
        
        return sum;
    }
}