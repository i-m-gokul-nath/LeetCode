class Solution {
    public String reverseWords(String s) {
        char[] chars = s.toCharArray();
        int start = 0;

        for (int i = 0; i < chars.length; i++) {
            if (chars[i] == ' ' || i == chars.length - 1) {
                int end = i == chars.length - 1 ? i : i - 1;
                reverse(chars, start, end);
                start = i + 1;
            }
        }

        return new String(chars);
    }

    private void reverse(char[] chars, int start, int end) {
        while (start < end) {
            char temp = chars[start];
            chars[start] = chars[end];
            chars[end] = temp;
            start++;
            end--;
        }
    }
}
