class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        int end = 0;
        
        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i) == s.charAt(i - 1)) {
                end = i;
            } else {
                if (end - start >= 2) { // Large group with 3 or more characters
                    List<Integer> interval = new ArrayList<>();
                    interval.add(start);
                    interval.add(end);
                    result.add(interval);
                }
                start = i;
                end = i;
            }
        }
        
        // Check the last group
        if (end - start >= 2) { // Large group with 3 or more characters
            List<Integer> interval = new ArrayList<>();
            interval.add(start);
            interval.add(end);
            result.add(interval);
        }
        
        return result;
    }
}
