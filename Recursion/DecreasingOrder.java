public class DecreasingOrder {
    public static void DecNum(int n) {
        if(n == 1) {
            System.out.println(n);
            return;
        }
        System.out.println(n+" ");
        DecNum(n-1);
    }
    public static void IncNum(int n) {
        if(n == 1) {
            System.out.println(n);
            return;
        }
        IncNum(n-1);
        System.out.println(n);
    }
    public static void main(String args[]) {
        new DecreasingOrder().DecNum(10);
        new DecreasingOrder().IncNum(10);
    }
}
