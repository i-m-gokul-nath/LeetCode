class Solution {
    public int numIdenticalPairs(int[] nums) {
        // Create a HashMap to store the count of each number
        Map<Integer, Integer> countMap = new HashMap<>();
        int goodPairs = 0;

        // Count the occurrences of each number in nums
        for (int num : nums) {
            countMap.put(num, countMap.getOrDefault(num, 0) + 1);
        }

        // Calculate the number of good pairs
        for (int count : countMap.values()) {
            goodPairs += count * (count - 1) / 2; // Using the combination formula
        }

        return goodPairs;
    }
}
