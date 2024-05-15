package ArrayLists;

import java.util.ArrayList;

public class Sum2 { 
    public static boolean TwopointerAppSum2(ArrayList<Integer> list,int target) { //two pointer approach
        int pivot = -1;
        for(int i = 0;i<list.size();i++) {
            if(list.get(i) > list.get(i+1)) {
                pivot = i;
                break;
            }
        }
        int lp = pivot+1; //smallest
        int rp = pivot; //largest
        while(lp != rp) {
            if(list.get(lp) + list.get(rp) == target) {
                return true;
            }
            else if(list.get(lp) + list.get(rp) < target) {
                lp = (lp+1)%list.size();
            }
            else {
                rp = (list.size()+rp-1)%list.size();
            }
        }
        return false;
    }
    public static boolean pairsum2(ArrayList<Integer> list,int target) { //brute force
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
        list.add(11);
        list.add(15);
        list.add(6);
        list.add(8);
        list.add(9);
        list.add(10);
        System.out.println(pairsum2(list, 17));
        System.out.println(TwopointerAppSum2(list, 87 ));
}
}

