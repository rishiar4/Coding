class MyStack {

    /** Initialize your data structure here. */
    Queue<Integer> q1;
    Queue<Integer> q2;
    public MyStack() {
        q1 = new LinkedList<>();
        q2 = new LinkedList<>();
    }
    
    /** Push element x onto stack. */
    public void push(int x) {
        q2.add( x );
        while( q1.size() != 0 )
        {
            q2.add( q1.remove() );
        }
        Queue temp = q1;
        q1 = q2;
        q2 = temp;
        
    }
    
    /** Removes the element on top of the stack and returns that element. */
    public int pop() {
        if( q1.size() == 0 )
        {
            return -1;
        }
        else
        {
            return q1.remove();
        }
    }
    
    /** Get the top element. */
    public int top() {
        if( q1.size() == 0 )
        {
            return -1;
        }
        else
        {
            return q1.peek();
        }
    }
    
    /** Returns whether the stack is empty. */
    public boolean empty() {
        return q1.size() == 0;
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