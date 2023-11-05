class Solution {
    public double[] calcEquation(List<List<String>> equations, double[] values, List<List<String>> queries) {
        Map<String, Map<String, Double>> graph = buildGraph(equations, values);
        double[] results = new double[queries.size()];
        
        for (int i = 0; i < queries.size(); i++) {
            String start = queries.get(i).get(0);
            String end = queries.get(i).get(1);
            Set<String> visited = new HashSet<>();
            results[i] = dfs(graph, start, end, 1.0, visited, new HashMap<>());
        }
        
        return results;
    }

    private Map<String, Map<String, Double>> buildGraph(List<List<String>> equations, double[] values) {
        Map<String, Map<String, Double>> graph = new HashMap<>();
        
        for (int i = 0; i < equations.size(); i++) {
            String a = equations.get(i).get(0);
            String b = equations.get(i).get(1);
            double value = values[i];
            
            graph.computeIfAbsent(a, k -> new HashMap<>()).put(b, value);
            graph.computeIfAbsent(b, k -> new HashMap<>()).put(a, 1.0 / value);
        }
        
        return graph;
    }

    private double dfs(Map<String, Map<String, Double>> graph, String current, String target, double result, Set<String> visited, Map<String, Double> memo) {
        if (!graph.containsKey(current) || visited.contains(current)) {
            return -1.0;
        }
        
        if (current.equals(target)) {
            return result;
        }
        
        if (memo.containsKey(current)) {
            return memo.get(current);
        }
        
        visited.add(current);
        Map<String, Double> neighbors = graph.get(current);
        double tempResult = -1.0;
        
        for (Map.Entry<String, Double> neighbor : neighbors.entrySet()) {
            tempResult = dfs(graph, neighbor.getKey(), target, result * neighbor.getValue(), visited, memo);
            if (tempResult != -1.0) {
                break;
            }
        }
        
        visited.remove(current);
        memo.put(current, tempResult);
        
        return tempResult;
    }
}