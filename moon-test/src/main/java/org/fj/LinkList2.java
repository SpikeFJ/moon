package org.fj;

public class LinkList2 {
    private Node head = new Node(-1, null);

    class Node {
        private int value;
        private Node next;

        public Node(int value, Node next) {
            this.value = value;
            this.next = next;
        }
    }

    public void add(int value) {
        Node last = head;//找到最后一个节点(next为null)
        while (last.next != null) {
            last = last.next;
        }
        last.next = new Node(value, null);
    }

    void print() {
        Node tmp = head;
        while (tmp.next != null) {
            tmp = tmp.next;
            System.out.print(tmp.value + " ");
        }
        System.out.println();
    }

    /**
     * head--->1--->2--->3--->4
     * <p>
     * head委托给以1起始的链表，1委托给以2起始的链表，递归
     * 最后一个节点,需要翻转节点：4--->3，并且删除3--->4的指针
     * <p>
     * <p>
     * head<---1<---2<---3<---4
     * 此时有个问题head.next指向了null，需要将head.next置为4的
     */
    private void reverse() {
        reverse(head.next);
        head.next = newFirst;
    }

    private Node newFirst;

    Node reverse(Node node) {
        if (node.next == null) {
            newFirst = node;
            return node;
        }
        //1.递归调用next节点，返回原节点值
        Node pre = reverse(node.next);

        //2.指针翻转
        pre.next = node;

        //3.原有指针删除
        node.next = null;

        return node;
    }

    void anotherRever() {
        Node nodeLast = reverse2(head.next);
        head.next = nodeLast;
    }

    Node reverse2(Node node) {
        if (node.next == null) {
            return node;
        }
        //1.递归调用next节点，
        Node alwayLastNode = reverse2(node.next);

        //2.此处翻转当前节点(node）的
        node.next.next = node;

        //3.原有指针删除
        node.next = null;

        return alwayLastNode;
    }


    /**
     * 采用非递归方式
     */
    private void reverseWithDoublePoint() {

        if (head.next == null) {
            System.out.println("没有元素");
            return;
        }
        if (head.next.next == null) {
            System.out.println("只有一个元素");
            return;
        }

        Node pre = head.next;
        Node cur = pre.next;

        //第一个元素会转变为最后一个元素，所以指向为null，后续的元素会指向前一个元素
        pre.next = null;

        while (cur != null) {
            //cur的next元素后面需要指向前一个元素，所以需要将next暂存
            Node tmp = cur.next;

            cur.next = pre;

            pre = cur;
            cur = tmp;
        }
        head.next = pre;
    }

    public static void main(String[] args) {
        LinkList2 linkList2 = new LinkList2();
        linkList2.add(1);
        linkList2.add(2);
        linkList2.add(3);
        linkList2.add(4);
        linkList2.print();

        linkList2.reverseWithDoublePoint();
        linkList2.print();
    }
}
