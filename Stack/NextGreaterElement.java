/* this is next greater code from right  n - 0
if it asked for next greater from left just run for loop in increasing 0 - n
and if it asked for next smaller for right  change here arr[i] <= arr[s.peek()] for loop n - 0
or left then just change here arr[i] <= arr[s.peek()] for loop 0 - n */
 // most used logic
package Stack;
import java.util.*;
public class NextGreaterElement {
    public static void nextGre(int arr[],int nextGr[]) {
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1;i>=0;i--) {
            while(!s.isEmpty() && arr[s.peek()] <= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                nextGr[i] = -1;
            } else {
                nextGr[i] = arr[s.peek()];
            }
            s.push(i);
        }
    }
    public static void printStack(Stack<Integer> s) {
        while(!s.isEmpty()) {
            System.out.println(s.pop());
        }
    }
    public static void main(String args[]) {
        int arr[] = {6,8,0,1,3};
        int nextGr[] = new int[arr.length];
        nextGre(arr, nextGr);
        for(int i=0;i<nextGr.length;i++) {
            System.out.print(nextGr[i]+" ");
        }
    }
}
