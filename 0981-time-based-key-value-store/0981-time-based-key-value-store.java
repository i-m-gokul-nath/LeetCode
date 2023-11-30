import java.util.HashMap;
import java.util.TreeMap;

class TimeMap {

    private final HashMap<String, TreeMap<Integer, String>> data;

    public TimeMap() {
        data = new HashMap<>();
    }

    public void set(String key, String value, int timestamp) {
        data.putIfAbsent(key, new TreeMap<>());
        data.get(key).put(timestamp, value);
    }

    public String get(String key, int timestamp) {
        if (!data.containsKey(key)) {
            return "";
        }

        TreeMap<Integer, String> values = data.get(key);
        Integer floorKey = values.floorKey(timestamp);

        return floorKey != null ? values.get(floorKey) : "";
    }
}

public class Main {
    public static void main(String[] args) {
        TimeMap timeMap = new TimeMap();
        timeMap.set("foo", "bar", 1);
        System.out.println(timeMap.get("foo", 1)); // Output: "bar"
        System.out.println(timeMap.get("foo", 3)); // Output: "bar"
        timeMap.set("foo", "bar2", 4);
        System.out.println(timeMap.get("foo", 4)); // Output: "bar2"
        System.out.println(timeMap.get("foo", 5)); // Output: "bar2"
    }
}


/**
 * Your TimeMap object will be instantiated and called as such:
 * TimeMap obj = new TimeMap();
 * obj.set(key,value,timestamp);
 * String param_2 = obj.get(key,timestamp);
 */