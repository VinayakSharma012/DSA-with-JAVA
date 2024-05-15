package ArrayandStrings;

// by using brute force method
import java.util.*;
public class MaxSubArraySum {
    public void Sub(int marks[]) {
        int currSum = 0;
        int MaxSum = Integer.MIN_VALUE;
        for (int i = 0; i < marks.length; i++) {
            for (int j = i; j < marks.length; j++) {
                currSum = 0;
                for (int k = i; k <= j; k++) {
                    //subarray sum
                    currSum += marks[k];
                }
                System.out.println(currSum);
                if (MaxSum < currSum) {
                    MaxSum = currSum;
                }
            }
        }
        System.out.println("max sum = "+ MaxSum);
    }
    public static void main(String args[]) {
        int numbers[] = {-1,-2,-3,-4};
        MaxSubArraySum obj = new MaxSubArraySum();
        obj.Sub(numbers);
    }
}


