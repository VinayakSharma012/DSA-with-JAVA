package Heaps;

import java.util.PriorityQueue;

public class SlidingWindowMax {
    static class Pair implements Comparable<Pair> {
        int value;
        int idx;

        public Pair(int value, int idx) {
            this.value = value;
            this.idx = idx;
        }

        @Override
        public int compareTo(Pair p2) {
            //for descending reverse it

            return p2.value - this.value;
        }
    }
    public static void main(String args[]) {
        int arr[] = {1,3,-1,-3,5,3,6,7};
        int k = 3;//window size
        int result[] = new int[arr.length-k+1];//n-k+1

        PriorityQueue<Pair> pq = new PriorityQueue<>();

        //1st Window
        for(int i=0;i<k;i++) {
            pq.add(new Pair(arr[i],i));
        }

        result[0] = pq.peek().value;

        for(int i=k;i<arr.length;i++) {
            while(pq.size() > 0 && pq.peek().idx <= (i-k)) {
                pq.remove();
            }

            pq.add(new Pair(arr[i], i));
            result[i-k+1] = pq.peek().value;
        }

        //print result
        for(int i=0;i<result.length;i++) {
            System.out.print(result[i]+" ");
        }
    }
}
