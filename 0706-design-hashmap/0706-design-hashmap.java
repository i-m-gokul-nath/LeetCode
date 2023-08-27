class MyHashMap {
    private final int size = 1000001; 

    private int[] keys;
    private int[] values;

    public MyHashMap() {
        keys = new int[size];
        values = new int[size];
        Arrays.fill(keys, -1); 
    }

    private int hash(int key) {
        return key % size;
    }

    public void put(int key, int value) {
        int index = hash(key);
        
        while (keys[index] != -1) {
            if (keys[index] == key) {
                values[index] = value; 
                return;
            }
            index = (index + 1) % size;
        }
        
        keys[index] = key;
        values[index] = value;
    }

    public int get(int key) {
        int index = hash(key);

        while (keys[index] != -1) {
            if (keys[index] == key) {
                return values[index];
            }
            index = (index + 1) % size;
        }
        
        return -1;
    }

    public void remove(int key) {
        int index = hash(key);

        while (keys[index] != -1) {
            if (keys[index] == key) {
                keys[index] = -1;
                values[index] = 0; 
                return;
            }
            index = (index + 1) % size;
        }
    }
}


/**
 * Your MyHashMap object will be instantiated and called as such:
 * MyHashMap obj = new MyHashMap();
 * obj.put(key,value);
 * int param_2 = obj.get(key);
 * obj.remove(key);
 */