import java.util.*;

public class Solution{
    public static class Stack{
        int[] arr;
        int top1, top2;

        public Stack( int c )
        {
            arr = new int[ c ];
            top1 = -1;
            top2 = c;
        }

        public void push1( int x )
        {
            if( top1 == top2 )
            {
                System.out.println("Stack Overflow");
                return;
            }
            else
            {
                arr[++top1] = x;
            }
        }

        public void push2( int x )
        {
            if( top1 == top2 )
            {
                System.out.println("Stack Overflow");
                return;
            }
            else
            {
                arr[--top2] = x;
            }
        }

        public int size1()
        {
            return top1 + 1; 
        }
        public int size2()
        {
            return this.arr.length - top2;
        }

        public int pop1()
        {
            if( top1 == -1 )
            {
                System.out.println("Stack Underflow");
                return -1;
            }
            else
            {
                int rv = arr[ top1 ];
                arr[top1] = 0;
                top1--;
                return rv;
            }
        }

        public int pop2()
        {
            if( top2 == arr.length  )
            {
                System.out.println("Stack Underflow");
                return -1;
            }
            else
            {
                int rv = arr[ top2 ];
                arr[top2] = 0;
                top2++;
                return rv;
            }
        }

    }
    public static void main(String[] args) {
        Stack st = new Stack( 10 );
        st.push2( 10 );
        System.out.println( st.pop1() );
        System.out.println( st.pop2() );
        System.out.println( st.pop2() );
    }
}