

class Solution {
    public int minOperations(int[] nums, int k) {
        PriorityQueue<Long> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add((long) num);  }

        int ans = 0;
        
        while (!minHeap.isEmpty() && minHeap.peek() < k) {
            if (minHeap.size() < 2) return -1;

            long num1 = minHeap.poll();
            long num2 = minHeap.poll();
            
            long newValue = 2 * num1 + num2;
            minHeap.add(newValue);
            ans++; }

        return ans; } }