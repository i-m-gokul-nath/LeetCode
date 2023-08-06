import java.util.HashSet;

class Solution {
    public int[] fairCandySwap(int[] aliceSizes, int[] bobSizes) {
        int totalAlice = 0;
        int totalBob = 0;
        HashSet<Integer> bobSet = new HashSet<>();

        for (int aliceSize : aliceSizes) {
            totalAlice += aliceSize;
        }

        for (int bobSize : bobSizes) {
            totalBob += bobSize;
            bobSet.add(bobSize);
        }

        int diff = (totalBob - totalAlice) / 2;
        for (int aliceSize : aliceSizes) {
            int bobTarget = aliceSize + diff;
            if (bobSet.contains(bobTarget)) {
                return new int[]{aliceSize, bobTarget};
            }
        }

        return new int[0]; // Should never reach here if there is at least one valid answer
    }
}
