public class PowerOfX {
    public static int pow(int x,int n) {
        if(n == 0) {
            return 1;
        }
        int val = x*pow(x,n-1);
        return val;
    }
    public static int OptimizedPow(int x, int n) {
        if(n == 0) {
            return 1;
        }
        int halfPower = OptimizedPow(x, n/2) * OptimizedPow(x, n/2);
        // n is odd 
        if(n%2 != 0) {
            halfPower = x * halfPower;
        }
        return halfPower;
    }
    public static void main(String args[]) {
       System.out.println("value of given number is : "+pow(10,2));
       System.out.println("value of given number is : "+OptimizedPow(10,2));
}
}
