class Solution {
    public int sumCounts(List<Integer> nums) {
        int len = nums.size(), anst = 0;
        HashSet<Integer> h;
        for (int i = 0; i < len; i++) {
            h = new HashSet<>();
            for (int j = i; j < len; j++) {
                h.add(nums.get(j));
                anst += h.size()*h.size();
            }
        }
        return anst;
    }
}