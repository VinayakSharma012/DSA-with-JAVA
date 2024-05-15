package ArrayLists;
import java.util.ArrayList;
public class OperationArr {
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        //add elements operation
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        list.add(1,9);//takes O(n)
        System.out.println(list);
        //get operationn
        System.out.println(list.get(2));
        //remove operation
        list.remove(2);
        System.out.println(list);
        //set element at index
        list.set(2,10);
        System.out.println(list);
        //contains element operation
        System.out.println(list.contains(10));
        System.out.println(list.contains(3));

        //size of list
        System.out.println(list.size());

        //print Arraylist eith loop
        for(int i = 0;i<list.size();i++) {
            System.out.print(list.get(i)+" ");
        }
            //Multi dimensinal arraylist
            ArrayList<ArrayList<Integer>> mainL = new ArrayList<>();
            ArrayList<Integer> list1 = new ArrayList<>();
            list1.add(3);
            list1.add(6);
            mainL.add(list1);
            System.out.println(list1);

            //print multi with nested loop
            for(int i=0;i<mainL.size();i++) {
                ArrayList<Integer> currlist = mainL.get(i);
                for(int j=0;j<currlist.size();j++) {
                    System.out.print(currlist.get(j)+" ");
                }
                System.out.println();
            }
    }
}
