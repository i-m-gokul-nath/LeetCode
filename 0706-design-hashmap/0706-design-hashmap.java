class MyHashMap {
    private final int size = 1000001; // Considering maximum key value

    private int[] map;

    public MyHashMap() {
        map = new int[size];
        Arrays.fill(map, -1); // Initialize with -1 (indicating no value)
    }

    public void put(int key, int value) {
        map[key] = value;
    }

    public int get(int key) {
        return map[key];
    }

    public void remove(int key) {
        map[key] = -1;
    }
}

/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */