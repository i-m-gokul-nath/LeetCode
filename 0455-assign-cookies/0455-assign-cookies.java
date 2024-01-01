import java.util.Arrays;

class Solution {
    public int findContentChildren(int[] g, int[] s) {
        Arrays.sort(g);
        Arrays.sort(s);

        int contentChildren = 0;
        int i = 0; // Index for greed factors
        int j = 0; // Index for cookie sizes

        while (i < g.length && j < s.length) {
            if (s[j] >= g[i]) {
                contentChildren++;
                i++; // Move to the next child
            }
            j++; // Move to the next cookie
        }

        return contentChildren;
    }
}
