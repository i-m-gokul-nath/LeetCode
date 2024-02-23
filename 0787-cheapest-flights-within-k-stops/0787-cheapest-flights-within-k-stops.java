class Solution {
    public int findCheapestPrice(int n, int[][] flights, int src, int dst, int k) {
        Map<Integer, List<int[]>> adjList = new HashMap<>();
        
        for (int[] flight : flights) 
            adjList.computeIfAbsent(flight[0], value -> new ArrayList<int[]>())
                .add(new int[] { flight[1], flight[2] });
				
		Integer[][] memo = new Integer[n + 1][k + 1];
        int minPrice = dfs(adjList, src, dst, memo, k);
		
        return minPrice == Integer.MAX_VALUE ? -1: minPrice;
    }
    
    private int dfs(Map<Integer, List<int[]>> adjList, int curr, int dst, Integer[][] memo, int k) {   
        if (curr == dst)
			return 0;
        
		if (k < 0 || !adjList.containsKey(curr))
			return Integer.MAX_VALUE;
        
		if (memo[curr][k] != null) 
			 return memo[curr][k];
        
		int minPrice = Integer.MAX_VALUE;
		
        for (int[] next : adjList.get(curr)) {
			int price = dfs(adjList, next[0], dst, memo, k - 1);
			
            if (price != Integer.MAX_VALUE) 
                minPrice = Math.min(minPrice, price + next[1]);
        }
		
        return memo[curr][k] = minPrice;
    }
}