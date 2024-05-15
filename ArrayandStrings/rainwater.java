package ArrayandStrings;
public class rainwater {
    public static int TrappedRainWater(int height[]) {
        int trappedwater = 0;
        //calculate left max boundary
        //calculate right max boundary
        int leftmax[] = new int[height.length];
        leftmax[0] = height[0];
        for(int i=1;i<height.length;i++) {
            leftmax[i] = Math.max(height[i],leftmax[i-1]);
        }
        int rightmax[] = new int[height.length];
        rightmax[height.length-1] = height[height.length-1];
        for(int i=height.length-2;i>=0;i--) {
            rightmax[i] = Math.max(height[i],rightmax[i+1]);
        }
        //loop
        for(int i=0;i<height.length;i++) {
           int waterlevel = Math.min(leftmax[i],rightmax[i]);
            trappedwater += waterlevel - height[i];

        }
        return trappedwater;
        //water level = min(leftmax bound, rightmax bound)
        //trapped water = waterlevel - height[i]
    }
    public static void main(String args[]) {
     int arr[] = {4,2,0,6,3,2,5};
     rainwater obj = new rainwater();
     int tp = obj.TrappedRainWater(arr);
     System.out.println(tp);
    /* int w = 0; int wid = 1; int wl = 0;
     for(int i = 1; i < arr.length-1; i++) {
         if(arr[i-1] > arr[i+1]) {
             w = arr[i-1];
         }
         else if(arr[i-1] < arr[i+1]) {
             w = arr[i+1];
         }
         else {
             w = arr[i-1];
         }

         if(wl < 0) {
              wl = 0;
         }
         else {
             wl += (w-arr[i])*wid;
         }
     }
     System.out.println(wl); */
    }
}
