package Queue;
import java.util.*;
public class InterLeaveHalves {
    public static void printInterLeaveHalve(Queue<Integer> q) {
        int n = q.size();
        Queue<Integer> q1 = new LinkedList<>();
        for(int i=0;i<n/2;i++) {
            q1.add(q.remove());
        }

        while(!q1.isEmpty()) {
            q.add(q1.remove());
            q.add(q.remove());
        }
        while(!q.isEmpty()) {
            System.out.print(q.remove()+" ");
        }
    }
    public static void main(String args[]) {
        Queue<Integer> q = new LinkedList<>();
        q.add(1);
        q.add(2);
        q.add(3);
        q.add(4);
        q.add(5);
        q.add(6);
        q.add(7);
        q.add(8);
        q.add(9);
        q.add(10);

        printInterLeaveHalve(q);
    }
}
