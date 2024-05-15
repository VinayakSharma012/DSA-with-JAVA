package Queue;

//O(n)

public class QueueLL {
    static class Node {
        int data;
        Node next;
        Node(int data) {
            this.data = data;
            this.next = null;
        }
    }
    static class LLqueue {
        static Node head = null;
        static Node tail = null;

        public static boolean isEmpty() {
            return head == null && tail == null;
        }
        //add
        public static void add(int data) {
            Node newNode = new Node(data);
            if(head == null) {
                head = tail = newNode;
                return;
            }
            tail.next = newNode;
            tail = newNode;
        }
        public static int remove() {
            if(isEmpty()) {
                System.out.println("empty");
                return -1;
            }
            int result = head.data;
            //single element 
            if(tail == head) {
                tail = head = null;
            }
            else {
                head = head.next;
            }
            return result;
        }
        public static int peek() {
            if(isEmpty()) {
                System.out.println("empty");
                return -1;
            }
            return head.data;
        }
    }
    public static void main(String args[]) {
        LLqueue q = new LLqueue();
        q.add(1);
        q.add(2);
        q.add(3);
        

        while(!q.isEmpty()) {
            System.out.print(q.peek()+" ");
            q.remove();
        }
    }
}
