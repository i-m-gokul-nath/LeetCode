class Solution {
    public int[] rearrangeArray(int[] nums) {
        int n = nums.length;
        List<Integer> positive = new ArrayList<>();
        List<Integer> negative = new ArrayList<>();

        for (int num : nums) {
            if (num > 0) {
                positive.add(num);
            } else {
                negative.add(num);
            }
        }

        int[] result = new int[n];
        int i = 0, j = 0, k = 0;

        while (i < positive.size() && j < negative.size()) {
            result[k++] = positive.get(i++);
            result[k++] = negative.get(j++);
        }

        while (i < positive.size()) {
            result[k++] = positive.get(i++);
        }

        while (j < negative.size()) {
            result[k++] = negative.get(j++);
        }

        return result;
    }
}
