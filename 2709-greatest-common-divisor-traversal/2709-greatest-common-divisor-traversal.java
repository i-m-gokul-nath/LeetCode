class Solution {
    public boolean canTraverseAllPairs(int[] nums) {
        if (nums.length == 1) return true;

        Map<Integer, Integer> dsu = new HashMap<>();
        
        for (int num : nums) {
            if (num == 1) return false;
            Set<Integer> factors = findFactors(num);

            if (!dsu.containsKey(num)) dsu.put(num, num);

            for (int factor : factors) {
                if (!dsu.containsKey(factor)) dsu.put(factor, factor);

                union(dsu, num, factor);
            }
        }

        Set<Integer> components = new HashSet<>();
        for (int num : nums) {
            components.add(find(dsu, num));
        }

        return components.size() == 1;
    }

    private void union(Map<Integer, Integer> dsu, int num1, int num2) {
        int p1 = find(dsu, num1);
        int p2 = find(dsu, num2);
        dsu.put(p1, p2);
    }

    private int find(Map<Integer, Integer> dsu, int num) {
        if (dsu.getOrDefault(num, num) != num) {
            dsu.put(num, find(dsu, dsu.get(num)));
        }
        
        return dsu.getOrDefault(num, num);
    }

    private HashSet<Integer> findFactors(int number) {
        HashSet<Integer> primeFactors = new HashSet<>();
        
        while (number % 2 == 0) {
            primeFactors.add(2);
            number /= 2;
        }
        
        for (int i = 3; i <= Math.sqrt(number); i += 2) {
            while (number % i == 0) {
                primeFactors.add(i);
                number /= i;
            }
        }
        
        if (number > 2) {
            primeFactors.add(number);
        }
        
        return primeFactors;
    }
}