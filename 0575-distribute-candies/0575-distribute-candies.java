class Solution {
    public int distributeCandies(int[] candyType) {
        boolean[] candyPresent = new boolean[200001]; // Considering the constraint -10^5 <= candyType[i] <= 10^5
        
        int uniqueCandies = 0;
        for (int candy : candyType) {
            if (!candyPresent[candy + 100000]) {
                uniqueCandies++;
                candyPresent[candy + 100000] = true;
            }
        }
        
        return Math.min(uniqueCandies, candyType.length / 2);
    }
}
