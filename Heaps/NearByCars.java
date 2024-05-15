package Heaps;

import java.util.PriorityQueue;

public class NearByCars {
    static class Point implements Comparable<Point> {
        int x;
        int y;
        int disSQ;
        int idx;

        public Point(int x,int y,int disSQ, int idx) {
            this.x = x;
            this.y = y;
            this.disSQ = disSQ;
            this.idx = idx;
        }

        @Override
        public int compareTo(Point p2) {
            return this.disSQ - p2.disSQ; //ascending order
        }
    }
    public static void main(String args[]) {
        int pts[][] = {{3,3},{5,-1},{-2,4}};
        int k = 2;

        PriorityQueue<Point> pq = new PriorityQueue<>();
        for(int i=0;i<pts.length;i++) {
            int disSQ = pts[i][0] * pts[i][0] + pts[i][1] * pts[i][1];
            pq.add(new Point(pts[i][0], pts[i][1], disSQ, i));
        }

        //nearby cars
        for(int i = 0; i< k;i++) {
            System.out.print("C"+pq.remove().idx+" ");
        }
    }
}
