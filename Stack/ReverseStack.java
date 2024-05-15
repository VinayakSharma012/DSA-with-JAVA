package Stack;
import java.util.*;
public class ReverseStack {
    public static void pushBottom(Stack<Integer> s, int data) {
        //base case
        if(s.isEmpty()) {
            s.push(data);
            return;
        }
        //kaam
        int top = s.pop();
        pushBottom(s, data);
        s.push(top);
    }
    public static void reverseStack(Stack<Integer> s) {
        if(s.isEmpty()) {
            return;
        }
        int top = s.pop();
        reverseStack(s);
        pushBottom(s,top);
    }
    public static void printStack(Stack<Integer> s) {
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
    public static void main(String args[]) {
        Stack<Integer> s = new Stack<>();
        s.push(1);
        s.push(2);
        s.push(3);
        reverseStack(s);
        printStack(s);
    }
}
