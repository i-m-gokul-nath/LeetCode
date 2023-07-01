import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> triangle = new ArrayList<>();
        
        if (numRows == 0) {
            return triangle;
        }
        
        // First row is always [1]
        triangle.add(new ArrayList<>());
        triangle.get(0).add(1);
        
        for (int row = 1; row < numRows; row++) {
            List<Integer> currRow = new ArrayList<>();
            List<Integer> prevRow = triangle.get(row - 1);
            
            currRow.add(1); // First element is always 1
            
            for (int col = 1; col < row; col++) {
                int num = prevRow.get(col - 1) + prevRow.get(col);
                currRow.add(num);
            }
            
            currRow.add(1); // Last element is always 1
            
            triangle.add(currRow);
        }
        
        return triangle;
        
    }
}