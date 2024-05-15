package ArrayLists;

import java.util.ArrayList;

public class Sum1 {
    public static boolean TwopointerApp(ArrayList<Integer> list,int target) { //two pointer approach
        int lp = 0; int rp = list.size()-1;
        while(lp != rp) {
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }
            else if(list.get(lp) + list.get(rp) < target) {
                lp++;
            }
            else {
                rp--;
            }
        }
        return false;
    }
    public static boolean pairsum1(ArrayList<Integer> list,int target) { //brute force
        for(int i=0;i<list.size();i++) {
            for(int j=i+1;j<list.size();j++) {
                if(list.get(i) + list.get(j) == target) {
                    return true;
                }
            }
        }
        return false;
    }    
    public static void main(String args[]) {
        ArrayList<Integer> list = new ArrayList<>();
        list.add(1);
        list.add(2);
        list.add(3);
        list.add(4);
        list.add(5);
        System.out.println(pairsum1(list, 9));
        System.out.println(TwopointerApp(list, 9));
}
}
