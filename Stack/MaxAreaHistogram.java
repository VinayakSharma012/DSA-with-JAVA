package Stack;
import java.util.*;
public class MaxAreaHistogram {
    public static void MaxArea(int arr[]) {
        int maxArea = 0;
        int Smallleft[] = new int[arr.length];
        int Smallright[] = new int[arr.length];

        //next smaller right
        Stack<Integer> s = new Stack<>();
        for(int i=arr.length-1;i>=0;i--) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                //-1
                Smallright[i] = -1;
            } else {
                //top
                Smallright[i] = s.peek();
            }
            s.push(i);
        }
        //next smaller left
        s = new Stack<>();
        for(int i=0;i<arr.length;i++) {
            while(!s.isEmpty() && arr[s.peek()] >= arr[i]) {
                s.pop();
            }
            if(s.isEmpty()) {
                //-1
                Smallleft[i] = -1;
            } else {
                //top
                Smallleft[i] = s.peek();
            }
            s.push(i);
        }
        // current area : widht = j-i-1 = right[i]- left[i]-1;
        for(int i=0;i<arr.length;i++) {
            int Height=arr[i];
            int width = Smallright[i]-Smallleft[i]-1;
            int currArr = Height * width;
            maxArea = Math.max(maxArea, currArr);
        }
        System.out.println("max area of histogram is: "+ maxArea);
    }
    public static void main(String args[]) {
        int Height[] = {2,1,5,6,2,3};
        MaxArea(Height);
    }
}
