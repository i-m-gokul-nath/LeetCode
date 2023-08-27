class MyHashMap {
    private static final int SIZE = 10000;

    private Node[] buckets;

    public MyHashMap() {
        buckets = new Node[SIZE];
    }

    private int getIndex(int key) {
        return key % SIZE;
    }

    public void put(int key, int value) {
        int index = getIndex(key);

        if (buckets[index] == null) {
            buckets[index] = new Node(key, value);
        } else {
            Node current = buckets[index];
            while (current.next != null && current.key != key) {
                current = current.next;
            }

            if (current.key == key) {
                current.value = value; // Update existing value
            } else {
                current.next = new Node(key, value);
            }
        }
    }

    public int get(int key) {
        int index = getIndex(key);

        Node current = buckets[index];
        while (current != null) {
            if (current.key == key) {
                return current.value;
            }
            current = current.next;
        }

        return -1;
    }

    public void remove(int key) {
        int index = getIndex(key);

        Node dummy = new Node(-1, -1);
        dummy.next = buckets[index];
        Node prev = dummy, current = buckets[index];
        
        while (current != null) {
            if (current.key == key) {
                prev.next = current.next;
                break;
            }
            prev = current;
            current = current.next;
        }
        
        buckets[index] = dummy.next;
    }

    private static class Node {
        int key;
        int value;
        Node next;

        public Node(int key, int value) {
            this.key = key;
            this.value = value;
            this.next = null;
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