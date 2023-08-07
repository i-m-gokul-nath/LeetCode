import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    private Queue<Integer> queue;
    private Queue<Integer> tempQueue;

    public MyStack() {
        queue = new LinkedList<>();
        tempQueue = new LinkedList<>();
    }

    public void push(int x) {
        // Move all elements from the main queue to the tempQueue
        while (!queue.isEmpty()) {
            tempQueue.add(queue.poll());
        }

        // Add the new element to the main queue
        queue.add(x);

        // Move back all elements from the tempQueue to the main queue
        while (!tempQueue.isEmpty()) {
            queue.add(tempQueue.poll());
        }
    }

    public int pop() {
        return queue.poll();
    }

    public int top() {
        return queue.peek();
    }

    public boolean empty() {
        return queue.isEmpty();
    }
}


/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */