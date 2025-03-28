package Java_Basics.src.main.java.com.understanding.datastructures.Design;

public class MyLinkedList {
    ListNode head;
    ListNode tail;
    public MyLinkedList() {
        head = new ListNode(-1);
        tail = new ListNode(-1);
        head.next = tail;
        tail.prev = head;
        head.prev = tail;
        tail.next = head;
    }

    public int get(int index) {
        ListNode current = head.next;
        while(index > 0 && current.next != tail){
            current = current.next;
            index--;
        }

        if(index > 0)
            return -1;

        return current.val;
    }

    public void addAtHead(int val) {
        ListNode node = new ListNode(val);
        ListNode headNext = head.next;
        node.next = headNext;
        headNext.prev = node;
        head.next = node;
        node.prev = head;
    }

    public void addAtTail(int val) {
        ListNode node = new ListNode(val);
        ListNode tailPrev = tail.prev;
        tailPrev.next = node;
        node.next = tail;
        node.prev = tailPrev;
        tail.prev = node;
    }

    public void addAtIndex(int index, int val) {
        ListNode current = head.next;
        while(current != tail && index > 0){
            current = current.next;
            index--;
        }

        if(index == 0 && current != tail){
            ListNode currentPrev = current.prev;
            ListNode node = new ListNode(val);
            currentPrev.next = node;
            current.prev = node;
            node.prev = currentPrev;
            node.next = current;
        }else if(index == 0 && current == tail){
            addAtTail(val);
        }
    }

    public void deleteAtIndex(int index) {
        ListNode current = head.next;
        while(current != tail && index > 0){
            current = current.next;
            index--;
        }

        if(index == 0 && current != tail){
            ListNode currentNext = current.next;
            ListNode currentPrev = current.prev;
            currentNext.prev = currentPrev;
            currentPrev.next = currentNext;
        }
    }

    public class ListNode{
        int val;
        ListNode next;
        ListNode prev;
        public ListNode(int v){
            this.val = v;
        }
    }
}
