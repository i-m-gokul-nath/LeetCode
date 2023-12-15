class Solution {
    public int[] memLeak(int memory1, int memory2) {
        int time = 1;
        
        while (true) {
            if (memory1 >= memory2) {
                if (memory1 < time) {
                    break;
                }
                memory1 -= time;
            } else {
                if (memory2 < time) {
                    break;
                }
                memory2 -= time;
            }
            
            time++;
        }
        
        return new int[]{time, memory1, memory2};
    }
}
