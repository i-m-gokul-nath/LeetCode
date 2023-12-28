class Solution {
    public int[] executeInstructions(int n, int[] startPos, String s) {
        int m = s.length();
        int[] answer = new int[m];
        
        for (int i = 0; i < m; i++) {
            int[] currentPos = new int[]{startPos[0], startPos[1]};
            int instructions = 0;

            for (int j = i; j < m; j++) {
                char instruction = s.charAt(j);
                if (instruction == 'L' && currentPos[1] > 0) {
                    currentPos[1]--;
                } else if (instruction == 'R' && currentPos[1] < n - 1) {
                    currentPos[1]++;
                } else if (instruction == 'U' && currentPos[0] > 0) {
                    currentPos[0]--;
                } else if (instruction == 'D' && currentPos[0] < n - 1) {
                    currentPos[0]++;
                } else {
                    break;
                }
                instructions++;
            }
            
            answer[i] = instructions;
        }
        
        return answer;
    }
}