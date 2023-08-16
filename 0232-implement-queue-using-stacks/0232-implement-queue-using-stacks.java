class MyQueue {

    private Stack<Integer> enqueuingStack;
    private Stack<Integer> dequeuingStack;

    public MyQueue() {
        enqueuingStack = new Stack<>();
        dequeuingStack = new Stack<>();
    }
    
    public void push(int x) {
        enqueuingStack.push(x);
    }
    
    public int pop() {
        peek();
        return dequeuingStack.pop();
    }
    
    public int peek() {
        if (dequeuingStack.isEmpty()) {
            while (!enqueuingStack.isEmpty()) {
                dequeuingStack.push(enqueuingStack.pop());
            }
        }
        return dequeuingStack.peek();
    }
    
    public boolean empty() {
        return enqueuingStack.isEmpty() && dequeuingStack.isEmpty();
    }
}


/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */