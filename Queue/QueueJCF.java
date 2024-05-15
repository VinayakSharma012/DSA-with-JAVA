package Queue;
import java.util.*;
public class QueueJCF {
    public static void main(String args[]) {
        Queue<Integer> qL = new LinkedList<>();
        Queue<Integer> qA = new ArrayDeque<>(); //queue is interface thats why we cant create its object and we used LL
        qL.add(1);
        qL.add(2);
        qL.add(3);
        while(!qL.isEmpty()) {
            System.out.print(qL.peek()+" ");
            qL.remove();
        }
        //Arraydeque same work but cache difff
        System.out.println();
        qA.add(1);
        qA.add(2);
        qA.add(3);
        while(!qA.isEmpty()) {
            System.out.print(qA.peek()+" ");
            qA.remove();
        }
    }
}
