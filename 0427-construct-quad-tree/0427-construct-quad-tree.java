/*
// Definition for a QuadTree node.
class Node {
    public boolean val;
    public boolean isLeaf;
    public Node topLeft;
    public Node topRight;
    public Node bottomLeft;
    public Node bottomRight;

    
    public Node() {
        this.val = false;
        this.isLeaf = false;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = null;
        this.topRight = null;
        this.bottomLeft = null;
        this.bottomRight = null;
    }
    
    public Node(boolean val, boolean isLeaf, Node topLeft, Node topRight, Node bottomLeft, Node bottomRight) {
        this.val = val;
        this.isLeaf = isLeaf;
        this.topLeft = topLeft;
        this.topRight = topRight;
        this.bottomLeft = bottomLeft;
        this.bottomRight = bottomRight;
    }
};
*/

class Solution {
    public Node construct(int[][] grid) {
        return buildQuadTree(grid, 0, 0, grid.length);
    }

    private Node buildQuadTree(int[][] grid, int x, int y, int size) {
        if (size == 0) {
            return null;
        }
        
        boolean isLeaf = true;
        int val = grid[x][y];
        
        for (int i = x; i < x + size; i++) {
            for (int j = y; j < y + size; j++) {
                if (grid[i][j] != val) {
                    isLeaf = false;
                    break;
                }
            }
            if (!isLeaf) {
                break;
            }
        }
        
        if (isLeaf) {
            return new Node(val == 1, true, null, null, null, null);
        } else {
            int half = size / 2;
            return new Node(false, false,
                buildQuadTree(grid, x, y, half),
                buildQuadTree(grid, x, y + half, half),
                buildQuadTree(grid, x + half, y, half),
                buildQuadTree(grid, x + half, y + half, half)
            );
        }
    }
}
