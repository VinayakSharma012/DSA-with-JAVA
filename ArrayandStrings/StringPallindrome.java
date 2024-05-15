package ArrayandStrings;
import java.util.Scanner;
public class StringPallindrome {
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println(" enter string :");
        String str = sc.nextLine();
        int k=0;
        for(int i=0;i<str.length()/2;i++) {
            int n = str.length();
            if(str.charAt(i) != str.charAt(n-i-1)) {
                // not a pallindrome
                k++; 
            }
        }
        if(k==0) {
            System.out.println(" is pallindrome");
        }
        else {
            System.out.println(" is not pallindrome");
        }
    }
}
