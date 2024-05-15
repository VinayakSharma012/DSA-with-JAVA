package ArrayandStrings;
import java.util.*;
// by using prefix array method
public class MaxSubArraySumm {
    public void Sub(int marks[]) {
        int currSum = 0;
        int MaxSum = Integer.MIN_VALUE;
        int prefix[] = new int[marks.length];
        //calculate prefix
        prefix[0] = marks[0];
        for(int i = 1; i <marks.length; i++) {
            prefix[i] = prefix[i-1] + marks[i];
        }
        for (int i = 0; i < marks.length; i++) {
            for (int j = i; j < marks.length; j++) {
                currSum = i == 0 ? prefix[j] : prefix[j] - prefix[i-1];
                if (MaxSum < currSum) {
                    MaxSum = currSum;
                }
            }
        }
        System.out.println("max sum = "+ MaxSum);
    }
    public static void main(String args[]) {
        int numbers[] = {2,4,6,8,10,};
        MaxSubArraySumm obj = new MaxSubArraySumm();
        obj.Sub(numbers);
    }
}

