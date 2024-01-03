class Solution {
    public int numberOfBeams(String[] bank) {
        int beams = 0;
        int prev_num = 0;
        int current_num = 0;
        for(int i=0;i<bank.length;i++){
            current_num = countOnes(bank[i]);
            beams += current_num*prev_num;
            if(current_num != 0) prev_num = current_num;
        }
        return beams;
    }

    private int countOnes(String str){
        int count = 0;
        for(int i=0;i<str.length();i++){
            if(str.charAt(i) == '1') count++;
        }
        return count;
    }
}