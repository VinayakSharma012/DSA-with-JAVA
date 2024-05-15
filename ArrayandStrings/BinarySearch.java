package ArrayandStrings;
import java.util.Scanner;

public class BinarySearch {
    public int BSearch(int marks[],int key) {
        int start = 0,end = marks.length-1;

        while(start <= end) {
            int mid = (start + end)/2;
            if(marks[mid] == key) {
                return mid;
            }
            else if(marks[mid] < key) {
                start = mid + 1;
            }
            else {
                end = mid - 1;
            }
        }
       return -1;
    }
    public static void main(String args[]) {
        int numbers[] = {65,76,78,98,99,121,432}; // array must be sorted`
        Scanner sc = new Scanner(System.in);
        System.out.println("enter the key to search");
        int value = sc.nextInt();
        BinarySearch obj = new BinarySearch();
        int index = obj.BSearch(numbers,value);
        if(index == -1) {
            System.out.println(" key not found");
        }
        else {
            System.out.println(" key found " +numbers[index]+" at : "+index);
        }
    }
}

