class Solution {
    List<Integer> dp;
    Map<Integer, Integer> count;
    
    public long countPalindromePaths(List<Integer> parent, String s) {
        int n = parent.size();
        dp = new ArrayList<>(Collections.nCopies(n, 0));
        count = new HashMap<>();
        long res = 0;
        for (int i = 0; i < n; i++) {
            int mask = bit(parent, s, i);
            int v = count.getOrDefault(mask, 0);
            for (int j = 0; j < 26; j++)
                res += count.getOrDefault(mask ^ (1 << j), 0);
            res += v;
            count.put(mask, v + 1);
        }
        return res;
    }

    private int bit(List<Integer> parent, String s, int i) {
        if (i > 0 && dp.get(i) == 0)
            dp.set(i, bit(parent, s, parent.get(i)) ^ (1 << (s.charAt(i) - 'a')));
        return dp.get(i);
    }
}