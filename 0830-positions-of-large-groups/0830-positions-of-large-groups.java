class Solution {
    public List<List<Integer>> largeGroupPositions(String s) {
        List<List<Integer>> result = new ArrayList<>();
        int start = 0;
        char currentChar = s.charAt(0);

        for (int i = 1; i < s.length(); i++) {
            char c = s.charAt(i);
            if (c != currentChar) {
                if (i - start >= 3) {
                    result.add(Arrays.asList(start, i - 1));
                }
                start = i;
                currentChar = c;
            }
        }

        if (s.length() - start >= 3) {
            result.add(Arrays.asList(start, s.length() - 1));
        }

        return result;
    }
}
