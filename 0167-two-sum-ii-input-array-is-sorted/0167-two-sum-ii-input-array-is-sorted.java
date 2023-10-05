class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int left = 0;
        int right = numbers.length - 1;

        while (left < right) {
            int sum = numbers[left] + numbers[right];
            if (sum == target) {
                return new int[] { left + 1, right + 1 };
            } else if (sum < target) {
                while (left < right && numbers[left] == numbers[left + 1]) left++; // Skip duplicates.
                left++;
            } else {
                while (left < right && numbers[right] == numbers[right - 1]) right--; // Skip duplicates.
                right--;
            }
        }

        return new int[0];
    }
}
