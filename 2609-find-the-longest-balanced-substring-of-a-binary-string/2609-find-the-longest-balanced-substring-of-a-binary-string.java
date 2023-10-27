class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int c1 = 0, c0 = 0, len = 0;
        char a[] = s.toCharArray();

        for (int i = 0; i < s.length(); i++) {
            if (a[i] == '0') {
                if (c1 == 0) {
                    // Increment c0 if no '1's encountered so far
                    c0++;
                } else {
                    // Calculate the length of a balanced substring
                    len = Math.max(len, Math.min(c1, c0) * 2);
                    // Reset counts for '0' and '1'
                    c0 = 1;
                    c1 = 0;
                }
            } else {
                // Increment c1 for '1'
                c1++;
            }
        }

        // Calculate the length of the last potential balanced substring
        len = Math.max(len, Math.min(c1, c0) * 2);

        // Return the length of the longest balanced substring
        return len;
    }
}