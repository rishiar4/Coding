import java.util.*;

public class Solution{

    public static class Linked{
        LinkedList<Integer> list;
        public Linked(){
        list = new LinkedList<>();
        }
    

    public void push( int x )
    {
        list.addFirst( x );
    }

    public int pop()
    {
        if(list.size() == 0 )
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        else
        {
            return list.removeFirst();
        }
    }

    public int peek()
    {
        if(list.size() == 0 )
        {
            System.out.println("Stack Underflow");
            return -1;
        }
        else
        {
            return list.getFirst();
        }
    }

    public boolean isEmpty()
    {
        return list.size() == 0;
    }

    public int size()
    {
        return list.size();
    }
    }
    public static void solve()
    {
        Linked st = new Linked();

        st.push( 100 );
        st.push( 200 );

        st.push( 30 );

        System.out.println(st.peek());
        st.pop();
        System.out.println( st.peek() );
        st.pop();
        st.pop();
        System.out.println( st.size());
    }

    public static void main(String[] args) {
        solve();
    }
}