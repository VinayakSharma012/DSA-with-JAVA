package ArrayandStrings;
//max sub array sum using kadane's algorithm
public class kadanealgo {
    public static void kadane(int marks[]) {
        int count = 0;
        int ms = Integer.MIN_VALUE;
        int cs = 0;
        for (int i = 0; i < marks.length; i++) {
            if (marks[i] < 0) {
                count++;
            }
        }
        if (count == marks.length) {
            for (int i = 0; i < marks.length; i++) {
                if (marks[i] > ms) {
                    ms = marks[i];
                }
            }
            System.out.println(" subarray sum is : " + ms);
        } else {

            for (int i = 0; i < marks.length; i++) {
                cs = cs + marks[i];
                if (cs < 0) {
                    cs = 0;
                }
                ms = Math.max(cs, ms);
            }

            System.out.println(" subarray sum is : " + ms);
        }
    }
    public static void main(String args[]) {
        int numbers[] = {-2,-3,4,-1,-2,1,5,-3};
        kadanealgo obj = new kadanealgo();
        obj.kadane(numbers);
    }
}
