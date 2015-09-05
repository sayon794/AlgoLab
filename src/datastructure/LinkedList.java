package datastructure;

public class LinkedList {
    public Link head = new Link(-1);
    public Link tail = new Link(-1);
    public Link node = null;
    
    public LinkedList() {
        head.next = tail;
        tail.prev = head;
    }
    
    public void addFront(int v) {
        Link temp = new Link(v);
        temp.next = head.next;
        temp.prev = head;
        temp.next.prev = temp;
        head.next = temp;
    }
    
    public void addBack(int v) {
        Link temp = new Link(v);
        temp.prev = tail.prev;
        temp.next = tail;
        tail.prev.next = temp;
        tail.prev = temp;
    }
    
    public void removeBack() {
        if(this.empty()) {
            return;
        }
        Link temp = tail.prev;
        tail.prev = temp.prev;
        temp.prev.next = tail;
    }
    
    public void removeFront() {
        if(this.empty()) {
            return;
        }
        Link temp = head.next;
        head.next = temp.next;
        temp.next.prev = head;
    }
    
    public boolean empty() {
        return (head.next == tail);
    }
    
}
