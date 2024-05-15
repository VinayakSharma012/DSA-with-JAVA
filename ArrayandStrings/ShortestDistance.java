package ArrayandStrings;
import java.util.Scanner;

public class ShortestDistance {
    public static double getpath(String path) {
        int x =0,y=0;
        for(int i=0;i<path.length();i++) {
            char dir = path.charAt(i);
            //south
            if(dir == 'S') {
                y--;
            }
            //north
            else if(dir == 'N') {
                y++;
            }
            else if(dir == 'W') {
                x--;
            }
            else {
                x++;
            }
        }
        double X= Math.pow(x,2);
        double Y = Math.pow(y,2);
        return Math.sqrt(X+Y);
    }
    public static void main(String args[]) {
        ShortestDistance obj = new ShortestDistance();
        Scanner sc = new Scanner(System.in);
        System.out.println(" enter path :");
        String pathh = sc.nextLine();
        double distance = obj.getpath(pathh);
        System.out.println(" path distance is : "+distance);
    }
}
