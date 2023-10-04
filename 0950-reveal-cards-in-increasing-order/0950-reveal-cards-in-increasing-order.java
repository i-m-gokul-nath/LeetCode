import java.util.Arrays;
import java.util.LinkedList;
import java.util.Queue;

class Solution {
    public int[] deckRevealedIncreasing(int[] deck) {
        int n = deck.length;
        
        // Sort the deck in ascending order.
        Arrays.sort(deck);
        
        // Initialize a queue to simulate revealing the cards.
        Queue<Integer> queue = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            queue.add(i);
        }
        
        int[] result = new int[n];
        for (int card : deck) {
            result[queue.poll()] = card; // Reveal the card and place it in the result array.
            if (!queue.isEmpty()) {
                queue.add(queue.poll()); // Move the next card to the bottom of the deck.
            }
        }
        
        return result;
    }
}
