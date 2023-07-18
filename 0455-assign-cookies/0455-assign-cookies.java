import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int gPointer = 0; // Pointer for greed factors
        int sPointer = 0; // Pointer for cookie sizes
        int contentChildren = 0; // Count of content children

        while (gPointer < g.length && sPointer < s.length) {
            if (s[sPointer] >= g[gPointer]) {
                // Assign this cookie to the child
                contentChildren++;
                gPointer++;
                sPointer++;
            } else {
                // Move to the next cookie
                sPointer++;
            }
        }

        return contentChildren;
    }
}
