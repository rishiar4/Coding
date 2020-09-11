public class client{
    public static void main(String[] args) throws Exception {
        
        Queue qu = new Queue();

        qu.add(100);
        qu.add(200);
        qu.add(450);


        System.out.println(qu);

        System.out.println( qu.remove() );

        System.out.println(qu);

        System.out.println( qu.size() );

        qu.remove();
        qu.remove();

        // Using try & catch for remove.
        try {
            qu.remove();
            
        } catch (Exception e) {
            //TODO: handle exception
            System.out.println(e);
        }
        

        System.out.println( qu.isEmpty() );

    }
}