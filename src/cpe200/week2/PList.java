package cpe200.week2;

public class PList {

    public PList() { head = tail = null; }

    public void pushToHead(char i) {
        head = new PNode(i, head, null);
        if (tail==null)
            tail = head;
        else
            head.next.prev = head;
        size++;
    }

    public void pushToTail(char i) {
        PNode tmp = tail;
        tail =new PNode(i,null,tail);
        if(head ==null){
            head=tail;
        }else {
            tail.prev=tmp;
        }size++;

    }

    public char popHead() {
        char i=head.data;
        PNode tmp = head;

        if (head==tail)
            head = tail = null;
        else {
            head = head.next;
            head.prev = null;
            tmp.next = null;
        }

        size--;

        return i;
    }

    public char popTail() {
        char el = tail.data;
        PNode tmp =  tail;
        if(head==tail)
        {
            head = tail = null;
        }else
        {
            tail = tail.prev;

        }tail.next =null;
        tmp.prev = null;
        size--;
        return el;
    }

    public boolean search(char i) {
        PNode tmp =head;
        while(tmp!=null)
        {
          if(i==tmp.data)
          {
              return true;
          }else{
              tmp=tmp.next;
          }
        }

        return false;
    }

    public boolean isEmpty() { return (head == null); }

    public void printForward() {
        PNode tmp = head;

        while (tmp != null) {
            System.out.println(tmp.data);
            tmp = tmp.next;
        }
        System.out.println();
    }

    public void printBackward() {
        PNode tmp = tail;
        while(tmp != null)
        {
            System.out.println(tmp.data);
            tmp = tmp.prev;
        }
        System.out.println();
    }

    public int getSize() {
        return size;
    }

    private PNode head, tail;
    private int size=0;
}
