class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> uniqueCandies = new HashSet<>();
        
        for (int candy : candyType) {
            uniqueCandies.add(candy);
        }
        
        int maxCandies = candyType.length / 2;
        
        return Math.min(uniqueCandies.size(), maxCandies);
    }
}
