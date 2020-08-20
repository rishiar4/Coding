// import java.util.*;

public class Solution{

    public static class Stack{
        int[] arr;
        int c;
        int top;

        public Stack( int c )
        {
            this.c = c;
            arr = new int[ c ];
            top = -1;
        }

        public void push( int x )
        {
            if( top + 1 == c )
            {
                System.out.println("Stack Overflow ");
                return;
            }
            else
            {
                top++;
                arr[top] = x; 
            }
        } 

        public int pop()
        {
            if( top == -1 )
            {
                System.out.println("Stack Underflow");
                return -1;
            }
            else
            {
                int rValue = arr[ top ];
                arr[ top ] = 0;
                top--;
                return rValue;
            }
        }

        public int peek()
        {
            if( top == -1 )
            {
                System.out.println("Stack Underflow");
                return -1;
            }
            else
            {
                return arr[ top ];
            }
        }

        public boolean isEmpty()
        {
            return top == -1;
        }

        public int size()
        {
            return top + 1;
        }

    }

    public static void solve()
    {
        Stack st = new Stack( 5 );
        
        st.push( 10 );
        st.push( 20 );

        System.out.println( st.size() );

        System.out.println( st.pop() );

        System.out.println( st.isEmpty() );
    }
    public static void main(String[] args) {
        solve();
    }
}