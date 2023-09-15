class Solution {
    public int numJewelsInStones(String jewels, String stones) {
        // Create a HashSet to store the types of jewels
        HashSet<Character> jewelSet = new HashSet<>();
        for (char jewel : jewels.toCharArray()) {
            jewelSet.add(jewel);
        }
        
        int count = 0; // Counter for the number of jewels in stones
        
        // Iterate through the stones
        for (char stone : stones.toCharArray()) {
            // Check if the stone is a jewel
            if (jewelSet.contains(stone)) {
                count++;
            }
        }
        
        return count;
    }
}
