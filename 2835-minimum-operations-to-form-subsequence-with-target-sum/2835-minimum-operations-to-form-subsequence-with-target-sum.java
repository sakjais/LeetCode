class Solution {
    public int minOperations(List<Integer> nums, int target) {
        // by default it is minHeap. So, make it maxHeap.
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b)->b-a);
        long sum = 0;
        for(int num : nums){
            sum += num;
            pq.add(num);
        }
        int opt = 0;
        while(target>0){
            int front = pq.poll();
            sum -= front;

            if(front <= target) {
                target -= front;
            }
            else if(front > target && sum < target) {
                opt++;
                sum += front;
                pq.offer(front/2);
                pq.offer(front/2);
            }
            if(pq.isEmpty() && target != 0) {
                if(front > target && front != 1) {
                    opt++;
                    sum += front;
                    pq.offer(front/2);
                    pq.offer(front/2);
                }
                else {
                    return -1;
                }
            }
        }
        return opt;
    }
}