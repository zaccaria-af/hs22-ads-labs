package ch.zhaw.ads;

import java.util.AbstractList;
import java.util.Comparator;

public class MyList extends AbstractList {

    public MyList() {
        size = 0;
        head = new ListNode(null);
        head.prev = head;
        head.next = head;
    }

    protected int size;
    protected ListNode head;

    protected class ListNode {
        Object value;
        ListNode next, prev;

        ListNode(Object value) {
            this.value = value;
        }
    }

    @Override
    public void clear() {
        head.next = head;
        head.prev = head;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean remove(Object o) {
        ListNode tmp = head;
         while (!tmp.next.value.equals(o)) {
            if (tmp.next.equals(head)) {
               System.out.println("This node does not exist!");
               return false;
            }
            tmp = tmp.next;
        }
         tmp.next.next.prev = tmp;
         tmp.next = tmp.next.next;
         size--;
         return true;
    }

    @Override
    public boolean add(Object o) {
        ListNode newNode = new ListNode(o);
        if (!head.prev.equals(o)) {
            newNode.next = head;
            newNode.prev = head.prev;
            head.prev.next = newNode;
            head.prev = newNode;
            size++;
            return true;
        }
        return false;
    }

    @Override
    public Object get(int pos) {
        if (pos <= size) {
            ListNode tmp = head;
            for (int i = 0; i <= pos; i++) {
                tmp = tmp.next;
            }
            return tmp.value;
        }
        System.out.println("Object at position not found!");
        return null;
    }

    @Override
    public int size() {
        return size;
    }
}
