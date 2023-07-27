class Solution {
    public int[][] floodFill(int[][] image, int sr, int sc, int newColor) {
        int oldColor = image[sr][sc];
        if (oldColor != newColor) {
            dfs(image, sr, sc, oldColor, newColor);
        }
        return image;
    }
    
    private void dfs(int[][] image, int row, int col, int oldColor, int newColor) {
        int m = image.length;
        int n = image[0].length;
        
        if (row < 0 || row >= m || col < 0 || col >= n || image[row][col] != oldColor) {
            return;
        }
        
        image[row][col] = newColor;
        
        dfs(image, row - 1, col, oldColor, newColor); // Up
        dfs(image, row + 1, col, oldColor, newColor); // Down
        dfs(image, row, col - 1, oldColor, newColor); // Left
        dfs(image, row, col + 1, oldColor, newColor); // Right
    }
}
