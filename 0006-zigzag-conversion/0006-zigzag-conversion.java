class Solution {
    public String convert(String s, int numRows) {
        // Skip String that don't need processing at all
        if (numRows == 1 || numRows >= s.length()) {
            return s;
        }

        char[] result = new char[s.length()];
        int a = 0; // track current index in result
        int k = (numRows * 2) - 2; // index difference of char in the same row per zigzag pillars

        for(int i=0; i<numRows; i++) {
            int j = 0; //nth char of the current row
            int l = 2*i; //difference between diagonal char and next char on pillar (same row)
            int character = 0; //index of character to take from string

            do {
                if(j!=0 && l!=0 && l!=k) { //if j is not zero and l!=k, there's a char in the diagonal
                    character = i + (j*k) -l;
                    if(character<s.length()) {
                        result[a++] = s.charAt(character);
                    }
                }
                character = i + (j*k);
                if(character<s.length()) {
                    result[a++] = s.charAt(character);
                }
                j++;
            } while (character<s.length()); //loop while character does not exceed string lenth
        }

        return new String(result);
    }
}