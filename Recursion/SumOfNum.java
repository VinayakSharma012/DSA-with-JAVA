public class SumOfNum {
    public static int SumN(int n) {
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        int sum = n + SumN(n-1);
        return sum;
    }
    public static void main(String args[]) {
        System.out.println(SumN(5));
    }
    
}
