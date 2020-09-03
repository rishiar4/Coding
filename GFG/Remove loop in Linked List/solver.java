class solver
{
    public static void removeLoop(Node head){
       Node fast = head;
       Node slow = head;
       while( fast.next != null && fast.next.next != null )
       {
           fast = fast.next.next;
           slow = slow.next;
           if( fast == slow ) break;
       }
       if( slow == head )
       {
           slow = head;
           while( slow.next != head )
           {
               slow = slow.next;
           }
           slow.next = null;
       }
       if( slow == fast )
       {
           slow = head;
           while( slow.next != fast.next )
           {
               if( slow == fast.next )
               {
                   fast.next = null;
               }
               slow = slow.next;
               fast = fast.next;
           }
        fast.next = null;
       }
    }
}
