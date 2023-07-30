class Solution {
    public int[][] flipAndInvertImage(int[][] image) {
        int n = image.length;
        
        for (int i = 0; i < n; i++) {
            int left = 0;
            int right = n - 1;
            
            // Flip the row horizontally
            while (left < right) {
                int temp = image[i][left];
                image[i][left] = image[i][right];
                image[i][right] = temp;
                
                left++;
                right--;
            }
            
            // Invert the row
            for (int j = 0; j < n; j++) {
                image[i][j] = 1 - image[i][j];
            }
        }
        
        return image;
    }
}
