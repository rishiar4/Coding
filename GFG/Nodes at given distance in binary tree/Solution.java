// { Driver Code Starts
//Initial Template for Java

import java.io.*;
import java.util.*;

class Node  
{ 
    int data; 
    Node left, right; 
   
    public Node(int d)  
    { 
        data = d; 
        left = right = null; 
    } 
}

class GFG
{
    static Node buildTree(String str)
    {
        // Corner Case
        if(str.length() == 0 || str.equals('N'))
            return null;
        String[] s = str.split(" ");
        
        Node root = new Node(Integer.parseInt(s[0]));
        Queue <Node> q = new LinkedList<Node>();
        q.add(root);
        
        // Starting from the second element
        int i = 1;
        while(!q.isEmpty() && i < s.length)
        {
              // Get and remove the front of the queue
              Node currNode = q.remove();
        
              // Get the current node's value from the string
              String currVal = s[i];
        
              // If the left child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the left child for the current node
                  currNode.left = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.left);
              }
        
              // For the right child
              i++;
              if(i >= s.length)
                  break;
              currVal = s[i];
        
              // If the right child is not null
              if(!currVal.equals("N")) 
              {
        
                  // Create the right child for the current node
                  currNode.right = new Node(Integer.parseInt(currVal));
        
                  // Push it to the queue
                  q.add(currNode.right);
              }
              
              i++;
        }
    
        return root;
    }
    
    public static void main(String args[]) throws IOException
    {
    
       BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int t = Integer.parseInt(br.readLine().trim());
        while(t>0)
        {
            String s = br.readLine().trim();
            Node root = buildTree(s);
            Solution T = new Solution();
            int target = Integer.parseInt(br.readLine().trim());
            int k = Integer.parseInt(br.readLine().trim());
            ArrayList<Integer> res = new ArrayList<Integer>();
            res = T.KDistanceNodes(root,target,k);
            for(int i = 0;i<res.size();i++)
                System.out.print(res.get(i) + " ");
            System.out.println();    
            t--;
        }
    }
}
// } Driver Code Ends


//User function Template for Java

// class Node  
// { 
//     int data; 
//     Node left, right;
// }

class Solution
{
    public static boolean NTP( Node root, int target, ArrayList<Node> res )
    {
        if( root == null ) return false ;
        
        if( root.data == target )
        {
            res.add( root );
            return true;
        }
        boolean re = NTP( root.left, target, res ) || NTP( root.right, target, res );
        if( re )
        {
            res.add( root );
        }
        return re;
    }
    
    
    public static void kDown( Node root, int k, Node block, ArrayList<Integer> ans )
    {
        if( root == null || k < 0 || root == block ) return;
        
        if( k == 0 ) ans.add( root.data );
        
        kDown( root.left, k - 1, block, ans );
        kDown( root.right, k - 1, block, ans );
    }
    
    
    public static ArrayList<Integer> KDistanceNodes(Node root, int target , int k)
    {
        // return the sorted list of all nodes at k dist
        ArrayList<Integer> ans = new ArrayList<>();
        
        if( root == null ) return ans;
        
        ArrayList<Node> res = new ArrayList<>();
        NTP( root, target, res );
        
        Node prev = null;
        
        for( int i = 0; i < res.size(); i++ )
        {
            kDown( res.get(i), k - i, prev, ans );
            prev = res.get(i);
        }
        
        Collections.sort( ans );
        
        return ans;
    }
};