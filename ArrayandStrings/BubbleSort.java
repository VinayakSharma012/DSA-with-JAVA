package ArrayandStrings;
import java.util.Arrays;
import java.util.Collections;

public class BubbleSort {
    public static void Bubble(int marks[]) {
        for(int i=0;i<marks.length-1;i++) {
            boolean b = false;
            for(int j=0;j<marks.length-1-i;j++) {
                if(marks[j] > marks[j+1]) {
                    int tmp = marks[j];
                    marks[j] = marks[j+1];
                    marks[j+1] = tmp;
                }

            }
            if(b == false) {
                break;
            }
        }
        for(int i = 0;i < marks.length; i++) {
            System.out.print(marks[i]+"\t");
        }
        System.out.println();
    }
    public static void selection(int arr1[]) {
        for(int i=0;i<arr1.length-1;i++) {
            int CurrMin = i;
            for(int j=i+1;j<arr1.length;j++) {
                if(arr1[CurrMin] > arr1[j]) {
                    CurrMin = j;
                }
            }
            //swap
            int tmp = arr1[CurrMin];
            arr1[CurrMin] = arr1[i];
            arr1[i] = tmp;
        }
        for(int i = 0;i < arr1.length; i++) {
            System.out.print(arr1[i]+"\t");
        }
        System.out.println();

    }

    public static void Insertion(int arr2[]) {
        for (int i = 0; i < arr2.length; i++) {
            int curr = i;
            int prev = i - 1;
            //finding out current position to insert
            while (prev >= 0 && arr2[prev] > arr2[curr]) {
                arr2[prev + 1] = arr2[prev];
                prev--;
            }
            //insertion
            arr2[prev+1] = arr2[curr];
        }
        for(int i = 0;i < arr2.length; i++) {
            System.out.print(arr2[i]+"\t");
        }
        System.out.println();
    }

    public static void Inbuilt(int arr3[]) {
        Arrays.sort(arr3);
       // Arrays.sort(arr3, Collections.reverseOrder()); //works on object
        for(int i = 0;i < arr3.length; i++) {
            System.out.print(arr3[i]+"\t");
        }
        System.out.println();
    }
    public static void count(int arr4[]) {
        int largest = Integer.MIN_VALUE;
        for(int i=0;i<arr4.length;i++) {
            largest = Math.max(largest,arr4[i]);
        }
        int count[] = new int[largest+1];// for positive size
        for(int i=0;i<arr4.length;i++) {
            count[arr4[i]]++;
        }

        //sorting
        int j =0 ;
        for(int i=0;i<count.length;i++) {
            while(count[i] > 0) {
                arr4[j] =i;
                j++;
                count[i]--;
            }
        }
        for(int i = 0;i < arr4.length; i++) {
            System.out.print(arr4[i]+"\t");
        }
        System.out.println();

    }
    public static void main(String args[]) {
        int arr[] = {1,2,3,4,5};
        BubbleSort obj = new BubbleSort();
        obj.Bubble(arr);
        obj.selection(arr);
        obj.Insertion(arr);
        obj.Inbuilt(arr);
        obj.count(arr);
    }
}
