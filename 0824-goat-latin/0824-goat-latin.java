class Solution {
    public String toGoatLatin(String sentence) {
        StringBuilder result = new StringBuilder();
        String vowels = "aeiouAEIOU";
        String appendA = "a";
        
        int wordStart = 0;
        for (int i = 0; i <= sentence.length(); i++) {
            if (i == sentence.length() || sentence.charAt(i) == ' ') {
                String word = sentence.substring(wordStart, i);
                char firstChar = word.charAt(0);
                
                if (vowels.indexOf(firstChar) != -1) {
                    result.append(word).append("ma");
                } else {
                    result.append(word.substring(1)).append(firstChar).append("ma");
                }
                
                result.append(appendA);
                if (i != sentence.length()) {
                    result.append(" ");
                }
                
                appendA += "a";
                wordStart = i + 1;
            }
        }
        
        return result.toString();
    }
}
