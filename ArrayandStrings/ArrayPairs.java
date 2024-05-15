package ArrayandStrings;
import java.util.Scanner;
public class ArrayPairs {
    public void Pairs(int marks[]) {
        int totalpairs = 0;
        for(int i = 0; i < marks.length; i++) {
            int current = marks[i];
            for(int j = i+1; j < marks.length; j++) {
                    System.out.println("("+marks[i]+","+marks[j]+")");
                    totalpairs++;
            }
            System.out.println();
        }
        System.out.println(" total pairs :- "+totalpairs);

    }
    public static void main(String args[]) {
        int numbers[] = {1,2,3,4,5,6,7,8,9};
        Scanner sc = new Scanner(System.in);
        ArrayPairs obj = new ArrayPairs();
        obj.Pairs(numbers);
    }
}
