public class fibonacci {
    public static int FiSeries(int n) {
        if(n == 0) {
            return 0;
        }
        else if(n == 1) {
            return 1;
        }
        int fb1 = FiSeries(n-1);
        int fb2 = FiSeries(n-2);
        int Fibo = fb1 + fb2;
        return Fibo;
    }
    public static void main(String args[]) {
        System.out.println(FiSeries(27));
    }
}
