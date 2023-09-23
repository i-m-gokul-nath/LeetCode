import java.util.Arrays;

class Solution {
    public int[] sortByBits(int[] arr) {
        Integer[] boxedArr = Arrays.stream(arr).boxed().toArray(Integer[]::new);
        
        Arrays.sort(boxedArr, (a, b) -> {
            int countA = Integer.bitCount(a);
            int countB = Integer.bitCount(b);
            
            if (countA == countB) {
                return a - b;
            } else {
                return countA - countB;
            }
        });
        
        // Convert back to primitive int array
        for (int i = 0; i < arr.length; i++) {
            arr[i] = boxedArr[i];
        }
        
        return arr;
    }
}
