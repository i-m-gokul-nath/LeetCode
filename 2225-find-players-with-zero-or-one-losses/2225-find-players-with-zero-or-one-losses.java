import java.util.*;

class Solution {
    public List<List<Integer>> findWinners(int[][] matches) {
        Map<Integer, Integer> lostMatchesCount = new HashMap<>();

        for (int[] match : matches) {
            int winner = match[0];
            int loser = match[1];

            lostMatchesCount.put(winner, lostMatchesCount.getOrDefault(winner, 0));
            lostMatchesCount.put(loser, lostMatchesCount.getOrDefault(loser, 0) + 1);
        }

        List<Integer> noLostMatches = new ArrayList<>();
        List<Integer> oneLostMatch = new ArrayList<>();

        for (int i = 1; i <= 100000; i++) {
            if (lostMatchesCount.containsKey(i)) {
                int lostCount = lostMatchesCount.get(i);

                if (lostCount == 0) {
                    noLostMatches.add(i);
                } else if (lostCount == 1) {
                    oneLostMatch.add(i);
                }
            }
        }

        List<List<Integer>> result = new ArrayList<>();
        result.add(noLostMatches);
        result.add(oneLostMatch);

        return result;
    }
}
