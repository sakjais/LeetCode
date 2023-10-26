class Solution {
    Map<Integer, Integer> resource = new HashMap<>();
    public int minGroupsForValidAssignment(int[] nums) {
        int len = nums.length;
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        
        List<Integer> values = new ArrayList<>(map.values()); 
    
        // Just linear traversal to try each different group size, I started with applying binary search and found out it's wrong to use binary search for this question.
        // Start trying from the largest group size then expecting minimal group numbers.
        for (int i = len; i >= 0; i--) {
            int tmp = allCanDivide(values, i);
            if (tmp != -1) return tmp;
        }
        return -1;
    }
    
    private int allCanDivide(List<Integer> values, int i) {
        // Simply ensure all frequency can divide.
        int sum = 0;
        for (int n : values) {
            int tmp = canDivide(n, i);
            if (tmp == -1) {
                return -1;
            }
            sum += tmp;
        }
        return sum;
    }
    
    
    private int canDivide(int n, int i) {
        // For each frequency, can divide int i and i + 1, which is prioritized.
        int j = i + 1;
        for (int x = 0; x * i <= n; x++) {
            if ((n - x * i) % j == 0) {
                return x + (n - x * i) / j;
            }
        }
        
        // Can divide just by i.
        if (n % i == 0) return n / i;

        return -1;
    }
}