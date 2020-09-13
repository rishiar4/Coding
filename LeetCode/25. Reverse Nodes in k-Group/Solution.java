/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    ListNode tT = null;
    ListNode tH = null;

    public int length( ListNode head )
    {
        int len = 0;
        while( head != null )
        {
            len++;
            head = head.next;
        }
        return len;
    }

    public void addFirst( ListNode node )
    {
        if( tH == null )
        {
            tH = node;
            tT = node;
        }
        else
        {
            node.next = tH;
            tH = node;
        }
    }
    public ListNode reverseKGroup(ListNode head, int k) {
        
        if( head == null || head.next == null || k <= 1 )
        {
            return head;
        }

        int l = length( head );
        if( l < k ) return head;

        ListNode curr = head;

        ListNode oH = null;
        ListNode oT = null;

        int K = k;
        while( curr != null && l >= K )
        {
            k = K;
            while( k > 0 )
            {
                k--;
                ListNode nn = curr;
                curr = curr.next;
                nn.next = null;

                addFirst( nn );
            }
            if( oH == null )
            {
                oH = tH;
                oT = tT;
            }
            else
            {
                oT.next = tH;
                oT = tT;
            }
            tH = null;
            tT = null;
            l-=K;
        }
        oT.next = curr;
        return oH;
    }
}