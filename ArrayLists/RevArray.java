package ArrayLists;
import java.util.Collections;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Scanner;
public class RevArray {
    public static int LargestNumber(ArrayList<Integer> largest) {
        int temp = Integer.MIN_VALUE;
        for(int i = 0; i<largest.size(); i++) {
            if(largest.get(i) > temp) {
                temp = largest.get(i);
            }
        }
        return temp;
    }
    public static void reverse(ArrayList<Integer> list) {
        for(int i=list.size()-1;i>=0;i--) {
            System.out.print(list.get(i)+" ");
        }
    }
    public static void Swap(ArrayList<Integer> list,int idx1,int idx2) {
        int temp = list.get(idx1);
        list.set(idx1,list.get(idx2));
        list.set(idx2,temp);
    }
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(2);
        list.add(5);
        list.add(9);
        list.add(3);
        list.add(6);
        reverse(list);
        System.out.println();
        System.out.println(LargestNumber(list));
        System.out.println(list);
        Swap(list, 1, 3);
        System.out.println(list);
        Collections.sort(list);//sorting in ascending
        System.out.println(list);
        Collections.sort(list, Collections.reverseOrder());//sorting in AScending
        System.out.println(list);
    }
}
