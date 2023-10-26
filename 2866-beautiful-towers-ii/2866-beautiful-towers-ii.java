class Solution {
    public long maximumSumOfHeights(List<Integer> A) {
        int n = A.size();

        long[] left = new long[n];
        Stack<Integer> stack = new Stack<>();
        stack.push(-1);
        long res = 0, cur = 0;
        for (int i = 0; i < n; i++) {
            while (stack.size() > 1 && A.get(stack.peek()) > A.get(i)) {
                int j = stack.pop();
                cur -= 1L * (j - stack.peek()) * A.get(j);
            }
            cur += 1L * (i - stack.peek()) * A.get(i);
            stack.push(i);
            left[i] = cur;
        }

        stack.clear();
        stack.push(n);
        cur = 0;
        for (int i = n - 1; i >= 0; i--) {
            while (stack.size() > 1 && A.get(stack.peek()) > A.get(i)) {
                int j = stack.pop();
                cur -= 1L * -(j - stack.peek()) * A.get(j);
            }
            cur += 1L * -(i - stack.peek()) * A.get(i);
            stack.push(i);
            res = Math.max(res, left[i] + cur - A.get(i));
        }

        return res;
    }
}