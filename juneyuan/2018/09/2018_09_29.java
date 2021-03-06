class MyStack {
    Deque<Integer> q1;
    Deque<Integer> q2;
    Deque<Integer> q;

    /** Initialize your data structure here. */
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
        q = q1;
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        if (q == q1) {
            q1.offer(x);
        } else {
            q2.offer(x);
        }
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if (q.size() == 0) {
            q = (q1.size() == 0) ? q2 : q1;
        }
        Queue<Integer> tmp = (q == q1) ? q2 : q1;
        queueAtoQueueB(q, tmp);
        return q.poll();
    }
    
    /** Get the top element. */
    public int top() {
        if (q.size() == 0) {
            q = (q1.size() == 0) ? q2 : q1;
        }
        Queue<Integer> tmp = (q == q1) ? q2 : q1;
        queueAtoQueueB(q, tmp);
        return q.peek();
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.size() == 0 && q2.size() == 0;
    }
    
    private void queueAtoQueueB(Queue<Integer> qA, Queue<Integer> qB) {
        while (qA.size() > 1) {
            qB.offer(qA.poll());
        }
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
