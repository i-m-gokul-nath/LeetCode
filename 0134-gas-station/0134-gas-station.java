class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        int n = gas.length;
        int totalGas = 0;  
        int currentGas = 0;  
        int startStation = 0;  

        for (int i = 0; i < n; i++) {
            totalGas += gas[i] - cost[i];
            currentGas += gas[i] - cost[i];

            if (currentGas < 0) {
                currentGas = 0;
                startStation = i + 1;
            }
        }

        return totalGas < 0 ? -1 : startStation % n;
    }
}
