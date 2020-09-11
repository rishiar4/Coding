public class client{
    public static void main(String[] args) throws Exception {
        Stack st = new Stack();

        st.push(20);
        st.push(30);
        st.push(40);

        System.out.println( st );

        System.out.println( st.pop() );

        System.out.println( st );

        st.push( 50 );

        System.out.println( st.size() );
        

    }
}