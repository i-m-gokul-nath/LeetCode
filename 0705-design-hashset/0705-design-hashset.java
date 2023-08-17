import java.util.BitSet;

class MyHashSet {
    private BitSet set;

    public MyHashSet() {
        set = new BitSet(1000001); // Initialize the BitSet with a size of 10^6 + 1
    }
    
    public void add(int key) {
        set.set(key);
    }
    
    public void remove(int key) {
        set.clear(key);
    }
    
    public boolean contains(int key) {
        return set.get(key);
    }
}


/**
 * Your MyHashSet object will be instantiated and called as such:
 * MyHashSet obj = new MyHashSet();
 * obj.add(key);
 * obj.remove(key);
 * boolean param_3 = obj.contains(key);
 */