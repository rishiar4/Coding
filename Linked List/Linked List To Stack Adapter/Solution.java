import java.io.*;
import java.util.*;

public class Solution {

  public static class LLToStackAdapter {
    LinkedList<Integer> ll;

    public LLToStackAdapter() {
      ll = new LinkedList<>();
    }


    int size() {
      return ll.size();
    }

    void push(int val) {
        ll.addFirst( val );
    }

    int pop() {
      if( ll.size() == 0 )
      {
          System.out.println("Stack underflow");
          return -1;
      }
      else
      {
          int val = ll.getFirst();
          ll.removeFirst();
          return val;
      }
    }

    int top() {
      if( ll.size() == 0 )
      {
          System.out.println("Stack underflow");
          return -1;
      }
      else
      {
          int val = ll.getFirst();
          return val;
      }
    }
  }

  public static void main(String[] args) throws Exception {
    BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
    LLToStackAdapter st = new LLToStackAdapter();

    String str = br.readLine();
    while(str.equals("quit") == false){
      if(str.startsWith("push")){
        int val = Integer.parseInt(str.split(" ")[1]);
        st.push(val);
      } else if(str.startsWith("pop")){
        int val = st.pop();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("top")){
        int val = st.top();
        if(val != -1){
          System.out.println(val);
        }
      } else if(str.startsWith("size")){
        System.out.println(st.size());
      }
      str = br.readLine();
    }
  }
}