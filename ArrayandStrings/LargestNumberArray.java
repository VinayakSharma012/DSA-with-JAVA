package ArrayandStrings;
import java.util.*;

public class LargestNumberArray {

    public int LargestNumber(int largest[]) {
        int temp = Integer.MIN_VALUE;
        for(int i = 0; i<largest.length; i++) {
            if(largest[i] > temp) {
                temp = largest[i];
            }
        }
        return temp;
    }
    public int SmallestNumber(int smallest[]) {
        int small = Integer.MAX_VALUE;
        for(int i = 0; i<smallest.length; i++) {
            if(smallest[i] < small) {
                small = smallest[i];
            }
        }
        return small;
    }
    public static void main(String args[]) {
        int numbers[] = {98,54,56,78,87,65,78,93};
        Scanner sc = new Scanner(System.in);
        LargestNumberArray obj = new LargestNumberArray();
        int index = obj.LargestNumber(numbers);
            System.out.println(" largest number found is  " +index);
        int smal = obj.SmallestNumber(numbers);
        System.out.println(" smallest number found is  " +smal);
    }
}

