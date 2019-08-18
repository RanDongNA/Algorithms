class MyStack {
    Queue q = new LinkedList<Integer>();
    // Push element x onto stack.
    public void add(int x) {
        q.add(x);
    }

    // Removes the element on top of the stack.
    public void pop() {
        Queue q2 = new LinkedList<Integer>();
        int temp;
        temp = q.pop();
        while(!q.isEmpty()) {
            q2.add(temp);
            temp = q.pop();
        }
        q = q2;
    }

    // Get the top element.
    public int top() {
        Queue q2 = new LinkedList<Integer>();
        int temp;
        temp = q.pop();
        while(!q.isEmpty()) {
            q2.add(temp);
            temp = q.pop();
        }
        q2.add(temp);
        q = q2;
        return temp;
    }

    // Return whether the stack is empty.
    public boolean empty() {
        return q.isEmpty();
    }
    
    
}