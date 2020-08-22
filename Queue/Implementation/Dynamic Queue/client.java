public class client{
    public static void solve()
    {
        DQueue qq = new DQueue( 2 );
        qq.add( 10 );
        qq.add( 30 );
        qq.add( 40 );

        // qq.remove();
        qq.remove();
        qq.remove();
        qq.add( 100 );

        qq.add(100);
        qq.add(100);
        qq.add(100);
        System.out.println(qq.front());

        System.out.println(qq.capacity());

        System.out.println(qq);
    }
    public static void main(String[] args) {
        solve();
    }
}