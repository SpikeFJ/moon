package org.fj;

public class LinkList3 {
    private Node head;

    class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(int value) {
        if (head == null) {
            Node newNode = new Node(value, null);
            head = newNode;
        } else {
            Node last = head;//找到最后一个节点(next为null)
            while (last.next != null) {
                last = last.next;
            }
            last.next = new Node(value, null);
        }
    }

    void print() {
        Node tmp = head;
        while (tmp.next != null) {
            System.out.print(tmp.value + " ");
            tmp = tmp.next;
        }
        System.out.println();
    }
}
