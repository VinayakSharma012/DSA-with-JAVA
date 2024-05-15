package ArrayandStrings;
public class SubArrays {
    public void Sub(int marks[]) {
        int totalpairs = 0;
        for(int i = 0; i < marks.length; i++) {
            for(int j = i; j < marks.length; j++) {
                for(int k = i; k <= j; k++) {
                    System.out.print(marks[k]+"\t");
                }
                totalpairs++;
                System.out.println();
            }
            System.out.println();
        }
        System.out.println("totalpairs is : "+totalpairs);
    }
    public static void main(String args[]) {
        int numbers[] = {2,4,6,8,10,};
        SubArrays obj = new SubArrays();
        obj.Sub(numbers);
    }
}

