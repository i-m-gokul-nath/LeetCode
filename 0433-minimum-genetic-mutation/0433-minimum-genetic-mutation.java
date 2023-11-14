import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

class Solution {
    public int minMutation(String startGene, String endGene, String[] bank) {
        Set<String> bankSet = new HashSet<>();
        for (String gene : bank) {
            bankSet.add(gene);
        }

        if (!bankSet.contains(endGene)) {
            return -1; // End gene is not in the bank, no valid mutation
        }

        char[] mutationOptions = {'A', 'C', 'G', 'T'};

        Queue<String> queue = new LinkedList<>();
        Set<String> visited = new HashSet<>();

        queue.offer(startGene);
        visited.add(startGene);

        int mutations = 0;

        while (!queue.isEmpty()) {
            int size = queue.size();
            for (int i = 0; i < size; i++) {
                String currentGene = queue.poll();

                if (currentGene.equals(endGene)) {
                    return mutations;
                }

                char[] geneArray = currentGene.toCharArray();

                for (int j = 0; j < 8; j++) {
                    char originalChar = geneArray[j];

                    for (char mutation : mutationOptions) {
                        geneArray[j] = mutation;
                        String mutatedGene = new String(geneArray);

                        if (bankSet.contains(mutatedGene) && !visited.contains(mutatedGene)) {
                            queue.offer(mutatedGene);
                            visited.add(mutatedGene);
                        }
                    }

                    geneArray[j] = originalChar;
                }
            }

            mutations++;
        }

        return -1; // No valid mutation found
    }
}
