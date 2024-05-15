package Linkedlist;

public class DoublyLL {
    public static class Node {
        int data;
        Node next;
        Node prev;

        public Node(int data) {
            this.data = data;
            this.next = null;
            this.prev = null;
        }
    }

    public static Node head;
    public static Node tail;
    public static int size;

    // Add a node at the beginning of the list
    public void addFirst(int data) {
        Node newNode = new Node(data);
        if (head == null) {
            head = tail = newNode;
        } else {
            newNode.next = head;
            head.prev = newNode;
            head = newNode;
        }
        size++;
    }

    // Add a node at the end of the list
    public void addLast(int data) {
        Node newNode = new Node(data);
        if (tail == null) {
            head = tail = newNode;
        } else {
            tail.next = newNode;
            newNode.prev = tail;
            tail = newNode;
        }
        size++;
    }

    // Add a node at a specific position
    public void addAtPosition(int data, int position) {
        if (position < 0 || position > size) {
            System.out.println("Invalid position...");
            return;
        }

        if (position == 0) {
            addFirst(data);
        } else if (position == size) {
            addLast(data);
        } else {
            Node newNode = new Node(data);
            Node current = head;

            for (int i = 0; i < position - 1; i++) {
                current = current.next;
            }

            newNode.next = current.next;
            newNode.prev = current;
            current.next.prev = newNode;
            current.next = newNode;

            size++;
        }
    }

    // Remove the first node from the list
    public void removeFirst() {
        if (head == null) {
            System.out.println("LinkedList is empty...");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            head = head.next;
            head.prev = null;
        }

        size--;
    }

    // Remove the last node from the list
    public void removeLast() {
        if (tail == null) {
            System.out.println("LinkedList is empty...");
            return;
        }

        if (head == tail) {
            head = tail = null;
        } else {
            tail = tail.prev;
            tail.next = null;
        }

        size--;
    }

    // Remove a node from a specific position
    public void removeAtPosition(int position) {
        if (position < 0 || position >= size) {
            System.out.println("Invalid position...");
            return;
        }

        if (position == 0) {
            removeFirst();
        } else if (position == size - 1) {
            removeLast();
        } else {
            Node current = head;

            for (int i = 0; i < position; i++) {
                current = current.next;
            }

            current.prev.next = current.next;
            current.next.prev = current.prev;

            size--;
        }
    }

    // Traverse and print the list
    public void traverse() {
        Node current = head;
        while (current != null) {
            System.out.print(current.data + " ");
            current = current.next;
        }
        System.out.println();
    }

    // Reverse the doubly linked list
    public void reverse() {
        Node curr = head;
        Node prev = null;
        Node next;

        while (curr != null) {
            next = curr.next;
            curr.next = prev;
            curr.prev = next;
            prev = curr;
            curr = next;
        }
        head = prev;
    }

    public static void main(String args[]) {
        DoublyLL dll = new DoublyLL();

        dll.addFirst(1);
        dll.addFirst(2);
        dll.addFirst(3);

        dll.traverse(); // Output: 3 2 1

        dll.addLast(4);
        dll.addLast(5);

        dll.traverse(); // Output: 3 2 1 4 5

        dll.addAtPosition(6, 2);

        dll.traverse(); // Output: 3 2 6 1 4 5

        dll.removeFirst();

        dll.traverse(); // Output: 2 6 1 4 5

        dll.removeLast();

        dll.traverse(); // Output: 2 6 1 4

        dll.removeAtPosition(2);

        dll.traverse(); // Output: 2 1 4

        dll.reverse();

        dll.traverse();
    }
}
