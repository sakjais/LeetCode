class Solution {
    public List<String> getWordsInLongestSubsequence(int n, String[] words, int[] groups) {
        int[] check = new int[groups.length];
        int[] before = new int[groups.length];
        Arrays.fill(check, 1);
        Arrays.fill(before, -1);
        int index = 0;
        int max = 1;
        for (int i = 1; i < words.length; i++) {
            for (int j = i-1; j >= 0; j--) {
                if (groups[i] != groups[j] && ham(words[i], words[j])) {
                    if (check[j] + 1 > check[i]) {
                        check[i] = check[j] + 1;
                        before[i] = j;
                        if (check[i] > max) {
                            max = check[i];
                            index = i;
                        }
                    }
                }
            }
        }
        List<String> ans = new ArrayList<>();
        while (index >= 0) {
            ans.add(words[index]);
            index = before[index];
        }
        Collections.reverse(ans);
        return ans;
    }

    private boolean ham(String s1, String s2) {
        if (s1.length() != s2.length()) {
            return false;
        }
        int count = 0;
        for (int i = 0; i < s1.length(); i++) {
            if (s1.charAt(i) != s2.charAt(i)) {
                count++;
            }
            if (count > 1) {
                return false;
            }
        }
        return count == 1;
    }
}