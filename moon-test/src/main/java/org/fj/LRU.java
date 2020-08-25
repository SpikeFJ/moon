package org.fj;

import java.util.HashMap;

public class LRU {
    //用于快速存取节点
    private HashMap<Integer, LinkNode> values = new HashMap<>();
    private LinkNode head;
    private LinkNode tail;
    private int maxSize;

    /**
     * 链表节点
     */
    class LinkNode {
        Integer value;
        LinkNode pre;
        LinkNode next;
    }


    public LRU(int size) {
        maxSize = size;
        head = new LinkNode();
        tail = new LinkNode();
    }


    public void put(Integer value) {
        if (!values.containsKey(value)) {

            //超过容量
            if (values.size() >= maxSize) {
                tail.pre.next = null;
                System.out.println("删除节点：" + tail.value);
                values.remove(tail.value);
                tail = tail.pre;
            }
            //新增
            LinkNode newNode = new LinkNode();
            newNode.value = value;


            if (values.size() == 0) {
                tail = newNode;
                head = newNode;
            } else {
                newNode.next = head;
                head.pre = newNode;

                head = newNode;
            }

            values.put(value, newNode);
        } else {

            //值已存在，则将该元素提到队里头
            LinkNode existObj = values.get(value);

            if (existObj != tail) {
                existObj.next.pre = existObj.pre;
                existObj.pre.next = existObj.next;
            } else {
                existObj.pre.next = null;
                tail = existObj.pre;
            }
        }

    }

    public Integer get(Integer value) {
        if (!values.containsKey(value)) {
            System.out.println("value = [" + value + "]不存在。");
            return null;
        }

        //值已存在，则将该元素提到队里头
        LinkNode existObj = values.get(value);

        if (existObj != tail) {
            existObj.next.pre = existObj.pre;
            existObj.pre.next = existObj.next;
        } else {
            existObj.pre.next = null;
            tail = existObj.pre;
        }

        head.pre = existObj;
        existObj.next = head;
        head = existObj;

        return existObj.value;
    }

    public void print() {
        if (head == null) {
            System.out.println("容器为空。");
        } else {
            LinkNode currenet = head;
            while (currenet != null) {
                System.out.print(currenet.value + " ");
                currenet = currenet.next;
            }
            System.out.println("");
        }
    }

    public static void main(String[] args) {
        LRU lru = new LRU(3);
        lru.put(1);
        lru.print();//1

        lru.put(2);
        lru.print();//2,1

        lru.put(3);
        lru.print();//3,2,1

        lru.put(7);//移除1---> 7,3,2
        lru.print();


        lru.put(8);//移除2---> 8,7,3
        lru.print();

        lru.get(3);//3移到表头--->3,8,7
        lru.print();

        lru.put(4);//4,3,8
        lru.print();
    }
}
