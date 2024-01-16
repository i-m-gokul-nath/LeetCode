import java.util.ArrayList;
import java.util.HashMap;
import java.util.Random;

class RandomizedSet {

    private ArrayList<Integer> nums; 
    private HashMap<Integer, Integer> indexMap; 
    private Random rand;

    public RandomizedSet() {
        nums = new ArrayList<>();
        indexMap = new HashMap<>();
        rand = new Random();
    }

    public boolean insert(int val) {
        if (indexMap.containsKey(val)) {
            return false; 
        }

        nums.add(val);
        indexMap.put(val, nums.size() - 1);
        return true;
    }

    public boolean remove(int val) {
        if (!indexMap.containsKey(val)) {
            return false; 
        }

        int indexToRemove = indexMap.get(val);
        int lastElement = nums.get(nums.size() - 1);

        nums.set(indexToRemove, lastElement);
        indexMap.put(lastElement, indexToRemove);

        nums.remove(nums.size() - 1);
        indexMap.remove(val);

        return true;
    }

    public int getRandom() {
        int randomIndex = rand.nextInt(nums.size());
        return nums.get(randomIndex);
    }
}

public class Main {
    public static void main(String[] args) {
        RandomizedSet randomizedSet = new RandomizedSet();
        System.out.println(randomizedSet.insert(1)); // true
        System.out.println(randomizedSet.remove(2)); // false
        System.out.println(randomizedSet.insert(2)); // true
        System.out.println(randomizedSet.getRandom()); // Random element (either 1 or 2)
        System.out.println(randomizedSet.remove(1)); // true
        System.out.println(randomizedSet.insert(2)); // false
        System.out.println(randomizedSet.getRandom()); // Always 2
    }
}


/**
 * Your RandomizedSet object will be instantiated and called as such:
 * RandomizedSet obj = new RandomizedSet();
 * boolean param_1 = obj.insert(val);
 * boolean param_2 = obj.remove(val);
 * int param_3 = obj.getRandom();
 */