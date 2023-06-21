public class dMyList {
    Node head;
    Node tail;
    class Node{
        int value;
        Node next;
        Node prev;
    }
    public void pushFront(int value){
        Node cur = new Node();
        cur.value = value;
        if(head == null){
            tail = cur;
        }else {
            cur.next = head;
            head.prev = cur;
        }
        head = cur;
    }
    public void popFront(){
        if(head != null) {
            if(head.next != null)
                head = head.next;
            else {
                tail = null;
                head = null;
            }
        }
    }
    public void print(){
        Node node = this.head;
        while (node != null){
            System.out.printf(node.value + " ");
            node = node.next;
        }
        System.out.println();
    }
    public boolean find(int value){
        Node node = head;
        while (node != null){
            if (node.value == value){
                return true;
            }
            node = node.next;
        }
        return false;
    }

    public void pushBack(int value){
        Node node1 = new Node();
        node1.value = value;
        if(tail == null){
            head = node1;
        }else {
            node1.prev = tail;
            tail.next = node1;
        }
        tail = node1;
    }
    public void popBack(){
        if(tail != null){
            if(tail.prev != null){
                tail = tail.prev;
                tail.next = null;
            } else {
                head = null;
                tail = null;
            }
        }
    }
    public void sort(){
        boolean needSort = true;
        do {
          needSort = false;
          if (head != null) {
              Node node = head;
              while (node != null && node.next != null) {
                    if (node.value > node.next.value){
                        Node before = node.prev;
                        Node cur = node;
                        Node next = node.next;
                        Node after = next.next;

                        cur.next = after;
                        cur.prev = next;
                        next.next = cur;
                        next.prev = before;

                        if(after != null){
                            after.prev = cur;
                        } else {
                            tail = cur;
                        }
                        if (before != null){
                            before.next = next;
                        } else {
                            head = next;
                        }
                        needSort = true;
                    }
                    node = node.next;
              }
          }
        } while (needSort);
    }
    public static void main(String[] args) {
        dMyList list = new dMyList();
        for (int i = 0; i < 6; i++) {
            list.pushFront(i);
        }
//        list.popFront();
//        list.popFront();
//        list.print();
//        System.out.println(list.find(2));
//        list.pushBack(20);
//        list.print();
//        list.popBack();
//        list.print();
        list.sort();
        list.print();
    }
}
