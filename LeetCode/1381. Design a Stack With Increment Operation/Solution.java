class CustomStack {
    int[] arr;
    int top;
    public CustomStack(int maxSize) {
        arr = new int[ maxSize ];
        top = -1;
    }
    
    public void push(int x) {
        if( top + 1 == this.arr.length )
        {
            return;
        }
        else
        {
            arr[++top] = x;
        }
    }
    
    public int pop() {
        if( top == -1 )
        {
            return -1;
        }
        else
        {
            int rv = arr[top];
            arr[top] = 0;
            top--;
            return rv;
        }
    }
    
    public void increment(int k, int val) {
        for( int i = 0; i < k && i <= top; i++ )
        {
            arr[i]+= val;
        }
    }
}

/**
 * Your CustomStack object will be instantiated and called as such:
 * CustomStack obj = new CustomStack(maxSize);
 * obj.push(x);
 * int param_2 = obj.pop();
 * obj.increment(k,val);
 */