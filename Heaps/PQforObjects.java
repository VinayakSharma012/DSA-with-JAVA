package Heaps;

import java.util.PriorityQueue;
import java.util.Comparator;

public class PQforObjects {
    static class Student implements Comparable<Student> {
        String name;
        int rank;

        public Student(String name,int rank) {
            this.name = name;
            this.rank = rank;
        }
        @Override
        public int compareTo(Student s2) {
            return this.rank - s2.rank;
        }
    }
    public static void main(String args[]) {
        PriorityQueue<Student> pq = new PriorityQueue<>();
        //for reverse order
        //PriorityQueue<Student> pq = new PriorityQueue<>(Comparator.reverseOrder()); 
        pq.add(new Student("A",4));
        pq.add(new Student("B",6));
        pq.add(new Student("C",3));
        pq.add(new Student("D",1));
        pq.add(new Student("E",2));

        while(!pq.isEmpty()) {
            System.out.println(pq.peek().name+" - "+pq.peek().rank);
            pq.remove();
        }
    }
}
