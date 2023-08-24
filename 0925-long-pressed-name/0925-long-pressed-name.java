class Solution {
    public boolean isLongPressedName(String name, String typed) {
        int i = 0;  // Pointer for name
        int j = 0;  // Pointer for typed
        
        while (j < typed.length()) {
            if (i < name.length() && name.charAt(i) == typed.charAt(j)) {
                i++;
                j++;
            } else if (j == 0 || typed.charAt(j) != typed.charAt(j - 1)) {
                return false;
            } else {
                j++;
            }
        }
        
        return i == name.length();
    }
}
