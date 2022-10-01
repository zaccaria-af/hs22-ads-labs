package ch.zhaw.ads;

public class MySortedList extends MyList {

    @Override
    public boolean add(Object val) {
        ListNode newNode = new ListNode(val);
        ListNode tmp = head.next;

        while (tmp.value != null) {
            Comparable tmpStr = (Comparable) tmp.value;

            if (tmpStr.compareTo((Comparable)newNode.value) >= 0) {
                break;
            }

            tmp = tmp.next;
        }

        newNode.prev = tmp.prev;
        newNode.next = tmp;
        tmp.prev.next = newNode;
        tmp.prev = newNode;

        size++;
        return true;
    }

    @Override
    public boolean remove(Object o){
        ListNode tmp = head;
        ListNode nodeToDelete = null;

        for(int i = 0; i < size; i++){
            tmp = tmp.next;
            if(o.equals(tmp.value)){
                nodeToDelete = tmp;
                break;
            }
        }
        if(nodeToDelete != null){
            nodeToDelete.prev.next = nodeToDelete.next;
            nodeToDelete.next.prev = nodeToDelete.prev;
            size--;
            return true;
        }
        return false;
    }
}
