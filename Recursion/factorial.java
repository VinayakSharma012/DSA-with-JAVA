public class factorial {
    public static int fact(int n) {
        if(n == 0) {
            return 1;
        }
        int x = n*fact(n-1);
        return x;
    }
    public static void main(String args[]) {
       System.out.println("factorial of given number is : "+fact(5));
    }
}
