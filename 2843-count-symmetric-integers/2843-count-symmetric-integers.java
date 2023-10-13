public class Solution {
    public int countSymmetricIntegers(int l, int h) {
        int ans = 0;
        for (int i = l; i <= h; i++) {
            int c = 0, j = i;
            while (j > 0) {
                c++;
                j = j / 10;
            }
            if (c % 2 != 0)
                continue;

            j = i;
            int s = 0;
            int a = 0, b = 0;
            while (s < (c / 2)) {
                a = a + j % 10;
                j = j / 10;
                s++;
            }
            while (s < c) {
                b = b + j % 10;
                j = j / 10;
                s++;
            }
            if (a == b)
                ans++;
        }
        return ans;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int l = 1;  // Replace with your desired values for the range
        int h = 100;
        int result = solution.countSymmetricIntegers(l, h);
        System.out.println(result);
    }
}