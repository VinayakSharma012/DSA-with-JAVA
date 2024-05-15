public class power {
    public static boolean isPowerOfTwo(int n) {
        if((n & (n-1)) == 0) {
            return true;
        }
        else {
            return false;
        }
    }
    public static void main(String args[]) {
        //n & (n-1) = 0
        System.out.println(isPowerOfTwo(1024));
    }
}
