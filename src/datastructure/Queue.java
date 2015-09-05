package datastructure;

public class Queue {
    private Link head = new Link(-1);
    private Link tail = new Link(-1);
    
    public Queue() {
        head.next = tail;
        tail.prev = head;
    }
    
    public void push(int n) {
        Link temp = new Link(n);
        temp.next = head.next;
        temp.prev = head;
        head.next.prev = temp;
        head.next = temp;
    }
    
    public boolean empty() {
        return (head.next == tail);
    }
    
    public int pop() {
        if(this.empty()) {
            return -1;
        }
        Link temp = tail.prev;
        tail.prev = temp.prev;
        temp.prev.next = tail;
        return temp.val;
    }
    
}
