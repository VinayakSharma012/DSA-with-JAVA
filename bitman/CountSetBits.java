public class CountSetBits {
    public static int countSet(int n) {
        int count =0;
        //log n complexity
        while(n > 0) {
            if((n & 1) != 0) {
                count++;
            }
             n = n>>1;
        }
        return count;
    }
    public static int fastExpo(int a,int n) {
        int ans = 1;
        // calculating a to the power n
        while(n > 0) {
            if((n & 1) != 0) {
                ans = ans * a;
            }
            a = (a * a);
            n = n>>1;
        }
        return ans;
    }
    public static void main(String args[]) {
        //n & (n-1) = 0
        System.out.println(countSet(7));
        System.out.println(fastExpo(3,5));
    }
}
