package ArrayandStrings;
import java.util.Scanner;

public class LinearSearch {

    public int Search(int marks[],int key) {
        for(int i = 0; i<marks.length; i++) {
            if(marks[i] == key) {
               return i;
            }
        }
        return -1;
    }
    public static void main(String args[]) {
        int numbers[] = {98,54,56,78,87,65,78,98};
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the key to search");
        int value = sc.nextInt();
        LinearSearch obj = new LinearSearch();
        int index = obj.Search(numbers,value);
        if(index == -1) {
            System.out.println(" key not found");
        }
        else {
            System.out.println(" key found " +numbers[index]+" at : "+index);
        }
    }
}
