package BackTracking;

public class GridUsingMaths {
        public static int fact(int n) {
            if(n == 0) {
                return 1;
            }
            int x = n*fact(n-1);
            return x;
        }
        public static void main(String args[]) {
           int m = 3,n = 3;
           int ways = fact(n+m-2) / (fact(n-1)*fact(m-1));
           System.out.println(" total ways of grid are : "+ways);
        }
    }
    
