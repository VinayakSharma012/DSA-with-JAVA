package Stack;
import java.util.*;
public class ValidParentheses {
    public static boolean isValid(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            //opening
            if(ch == '(' || ch == '{' || ch == '[') {
                st.push(ch);
            }
            else {
                //closing
                if(st.isEmpty()) {
                    return false;
                }
                if((st.peek() == '(' && ch == ')') ||
                 (st.peek() == '[' && ch == ']') ||
                 (st.peek() == '{' && ch == '}')) {
                    st.pop();
                } else {
                    return false;
                }
            }
        }
        if(st.isEmpty()) {
            return true;
        } else {
            return false;
        }

    }
    public static void main(String args[]) {
        System.out.println("enter string :");
        String s = new Scanner(System.in).nextLine();
        if(isValid(s)) {
            System.out.println(s + " is valid");
        } else {
            System.out.println(s +"is not valid");
        }
    }
}
