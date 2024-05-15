package ArrayLists;

import java.util.ArrayList;

public class ContainerWithmostWater {
    public static int storeWater(ArrayList<Integer> height) { //brute force method
        int maxWater = 0;
        for(int i=0;i<height.size();i++) {
            for(int j=i+1;j<height.size();j++) {
                int ht = Math.min(height.get(i),height.get(j));
                int wt = j-i;
                int currWater = ht*wt;
                maxWater = Math.max(maxWater,currWater);
            }
        }
        return maxWater;
    }
    public static int TwoPointerAp(ArrayList<Integer> height) {
        int lp = 0; int maxWater = 0;
        int rp = height.size()-1;
        while(lp < rp) {
            int ht = Math.min(height.get(lp),height.get(rp));
            int wt = rp-lp;
            int currWater =  ht*wt;
            maxWater = Math.max(maxWater,currWater);
            if(height.get(lp) < height.get(rp)) {
                lp++;
            }
            else {
                rp--;
            }
        }
        return maxWater;
    }
    public static void main(String args[]) {
        ArrayList<Integer> height = new ArrayList<>();
        height.add(1);
        height.add(8);
        height.add(6);
        height.add(2);
        height.add(5);
        height.add(4);
        height.add(8);
        height.add(3);
        height.add(7);
        System.out.println(storeWater(height));
        System.out.println(TwoPointerAp(height));
    }
}
