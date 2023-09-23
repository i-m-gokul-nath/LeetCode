class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] sortedArr = new Integer[arr.length];
        
        // Convert int[] to Integer[] for custom sorting
        for (int i = 0; i < arr.length; i++) {
            sortedArr[i] = arr[i];
        }
        
        // Custom comparator for sorting
        Arrays.sort(sortedArr, (a, b) -> {
            int countA = Integer.bitCount(a); // Count 1's in binary representation of a
            int countB = Integer.bitCount(b); // Count 1's in binary representation of b
            
            if (countA == countB) {
                // If counts are equal, sort by the number itself
                return a - b;
            } else {
                // Otherwise, sort by the count of 1's
                return countA - countB;
            }
        });
        
        // Convert Integer[] back to int[]
        for (int i = 0; i < arr.length; i++) {
            arr[i] = sortedArr[i];
        }
        
        return arr;
    }
}
