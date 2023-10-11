import java.util.PriorityQueue;

class Solution {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(nums.length - k + 1, (a, b) -> b - a);
        
        for (int num : nums) {
            maxHeap.offer(num);
            if (maxHeap.size() > nums.length - k + 1) {
                maxHeap.poll();
            }
        }
        
        return maxHeap.peek();
    }
}
