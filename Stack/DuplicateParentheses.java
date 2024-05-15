package Stack;

import java.util.*;

public class DuplicateParentheses {
    public static boolean isDuplicate(String s) {
        Stack<Character> st = new Stack<>();
        for(int i=0;i<s.length();i++) {
            char ch = s.charAt(i);
            //opening
                st.push(ch);
                if(ch == ')') {
                    int count = 0;
                while(st.pop() == '(') {
                    count++;
                }
                if(count < 1) {
                    return true;
                }
            }
            else {
                st.push(ch);
            }
        }
        return false;
    }
    public static void main(String args[]) {
        System.out.println("enter string :");
        String s = new Scanner(System.in).nextLine();
        if(isDuplicate(s)) {
            System.out.println(s + " is duplicate");
        } else {
            System.out.println(s +"is not duplicate");
        }
    }
}
