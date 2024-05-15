package Stack;
import java.util.*;
public class ReverseString {
    public static String reverse(String str) {
        Stack<Character> s = new Stack<>();
        for(int i = 0; i < str.length(); i++) {
            s.push(str.charAt(i));
        }

        StringBuilder str1 = new StringBuilder();
        while(!s.isEmpty()) {
            char curr = s.pop();
            str1.append(curr);
        }
        return str1.toString();
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter string to reverse");
        String str = sc.nextLine();
        System.out.println(reverse(str));
        if(str.equals(reverse(str))) {
            System.out.println("woahh!! you found a pallindrome string");
        }
    }
}
