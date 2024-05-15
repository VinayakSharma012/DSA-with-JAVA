package ArrayandStrings;
import java.util.Scanner;

public class ReverseArray {

    public void Reverse(int marks[]) {
        int first = 0, last = marks.length - 1;

        while (first < last) {
            //swap
            int temp = marks[last];
            marks[last] = marks[first];
            marks[first] = temp;
            first++;
            last--;
        }
    }

    public static void main(String args[]) {
        int numbers[] = {98, 54, 56, 70, 87, 65, 78, 8};
        Scanner sc = new Scanner(System.in);
        ReverseArray obj = new ReverseArray();
        obj.Reverse(numbers);
        for(int i = 0; i < numbers.length; i++) {
            System.out.print( numbers[i] + "\t" );
        }
    }
}
