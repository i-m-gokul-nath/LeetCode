class Solution {
    public String shortestCompletingWord(String licensePlate, String[] words) {
        int[] licensePlateCounts = countLetters(licensePlate);
        String shortestWord = "";
        int shortestLength = Integer.MAX_VALUE;

        for (String word : words) {
            if (isCompletingWord(word, licensePlateCounts) && word.length() < shortestLength) {
                shortestWord = word;
                shortestLength = word.length();
            }
        }

        return shortestWord;
    }

    private int[] countLetters(String licensePlate) {
        int[] counts = new int[26];
        for (char c : licensePlate.toLowerCase().toCharArray()) {
            if (Character.isLetter(c)) {
                counts[c - 'a']++;
            }
        }
        return counts;
    }

    private boolean isCompletingWord(String word, int[] licensePlateCounts) {
        int[] wordCounts = countLetters(word);
        for (int i = 0; i < 26; i++) {
            if (wordCounts[i] < licensePlateCounts[i]) {
                return false;
            }
        }
        return true;
    }
}
