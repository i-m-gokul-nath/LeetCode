import java.util.TreeMap;

class MyCalendarTwo {
    private TreeMap<Integer, Integer> delta;

    public MyCalendarTwo() {
        delta = new TreeMap<>();
    }

    public boolean book(int start, int end) {
        
        delta.put(start, delta.getOrDefault(start, 0) + 1);
        delta.put(end, delta.getOrDefault(end, 0) - 1);

        int activeBookings = 0;
        int overlap = 0;

        for (int value : delta.values()) {
            activeBookings += value;
            if (activeBookings == 3) {

                delta.put(start, delta.get(start) - 1);
                delta.put(end, delta.get(end) + 1);
                return false;
            }
            overlap = Math.max(overlap, activeBookings);
        }

        return overlap <= 2;
    }
}

public class Main {
    public static void main(String[] args) {
        MyCalendarTwo myCalendarTwo = new MyCalendarTwo();
        System.out.println(myCalendarTwo.book(10, 20)); // true
        System.out.println(myCalendarTwo.book(50, 60)); // true
        System.out.println(myCalendarTwo.book(10, 40)); // true
        System.out.println(myCalendarTwo.book(5, 15));  // false
        System.out.println(myCalendarTwo.book(5, 10));  // true
        System.out.println(myCalendarTwo.book(25, 55)); // true
    }
}

/**
 * Your MyCalendarTwo object will be instantiated and called as such:
 * MyCalendarTwo obj = new MyCalendarTwo();
 * boolean param_1 = obj.book(start,end);
 */