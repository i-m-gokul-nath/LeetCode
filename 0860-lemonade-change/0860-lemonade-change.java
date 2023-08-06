class Solution {
    public boolean lemonadeChange(int[] bills) {
        int count5 = 0; // Number of $5 bills
        int count10 = 0; // Number of $10 bills
        
        for (int bill : bills) {
            if (bill == 5) {
                count5++;
            } else if (bill == 10) {
                if (count5 > 0) {
                    count5--;
                    count10++;
                } else {
                    return false; // Cannot provide change
                }
            } else if (bill == 20) {
                if (count10 > 0 && count5 > 0) {
                    count10--;
                    count5--;
                } else if (count5 >= 3) {
                    count5 -= 3;
                } else {
                    return false; // Cannot provide change
                }
            }
        }
        
        return true;
    }
}
