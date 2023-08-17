class Solution {
    public int distributeCandies(int[] candyType) {
        Set<Integer> candySet = new HashSet<>();
        
        for (int candy : candyType) {
            candySet.add(candy);
        }
        
        return Math.min(candySet.size(), candyType.length / 2);
    }
}
