class Solution {
    public int pivotInteger(int n) {
        
        int leftVal = 1;
        int rightVal = n;
        int sumLeft = leftVal;
        int sumRight = rightVal;

        if(n == 1) return n;

        while(leftVal < rightVal) {
            if(sumLeft < sumRight){
                sumLeft += ++leftVal;
            }
            else {
                sumRight += --rightVal;
            }

            if(sumLeft == sumRight && leftVal + 1 == rightVal - 1) {
                return leftVal + 1;
            }
        }
        return -1;
    }
}