import java.util.Scanner;
public class OddEven {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("enter number to check : ");
        int num = sc.nextInt();
        int BitMask = 1;
        if((num & BitMask) == 1) {
            System.out.println(" odd");
        }
        else {
            System.out.println(" even");
        }
    }
}
