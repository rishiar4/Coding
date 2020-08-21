import java.util.*;

public class Solution{
    public static class Stack{
        Queue<Integer> q1, q2;
        public Stack()
        {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }
        public void push( int x )
        {
            q1.add( x );

            while( q2.size() != 0 )
            {
                q1.add( q2.remove() );
            }

            Queue<Integer> temp = q2;
            q2 = q1;
            q1 = temp;
        }

        public int pop()
        {
            if( q2.size() == 0 )
            {
                System.out.println("Stack Underflow");
                return -1;
            }
            else
            {
                return q2.remove();
            }
        }

        public int size()
        {
            return q2.size();
        }
        
        public int top()
        {
            if( q2.size() == 0 )
            {
                System.out.println("Stack Underflow");
                return -1;
            }
            else
            {
                return q2.peek();
            }
        }

        public boolean isEmpty()
        {
            return q2.size() == 0;
        }
    }
    public static void main(String[] args) {
        Stack st = new Stack();
        st.push( 10 );
        st.push( 20 );
        System.out.println( st.size() );
        System.out.println( st.isEmpty() );
    }
}