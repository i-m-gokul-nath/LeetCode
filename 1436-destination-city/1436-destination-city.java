class Solution {
    public String destCity(List<List<String>> paths) {
        Set<String> outgoingCities = new HashSet<>();
        
        // Add all cities with outgoing paths to the set
        for (List<String> path : paths) {
            outgoingCities.add(path.get(0));
        }
        
        // Check for the destination city
        for (List<String> path : paths) {
            String destinationCity = path.get(1);
            if (!outgoingCities.contains(destinationCity)) {
                return destinationCity;
            }
        }
        
        // There will always be exactly one destination city
        return "";
    }
}
