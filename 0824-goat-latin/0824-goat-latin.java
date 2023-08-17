class Solution {
    public String toGoatLatin(String sentence) {
        String[] words = sentence.split(" ");
        StringBuilder result = new StringBuilder();
        String vowels = "aeiouAEIOU";
        String appendA = "a";
        
        for (int i = 0; i < words.length; i++) {
            String word = words[i];
            char firstChar = word.charAt(0);
            
            if (vowels.indexOf(firstChar) != -1) {
                result.append(word).append("ma");
            } else {
                result.append(word.substring(1)).append(firstChar).append("ma");
            }
            
            result.append(appendA);
            if (i != words.length - 1) {
                result.append(" ");
            }
            
            appendA += "a";
        }
        
        return result.toString();
    }
}
