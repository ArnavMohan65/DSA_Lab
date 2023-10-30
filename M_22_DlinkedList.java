//2.	Write a Program to implement doubly linked list and its operations.
public class M_22_DlinkedList {
    Node head;
    public static void main(String[] args) {
        M_22_DlinkedList l = new M_22_DlinkedList();
        l.insertFirst(3);
        l.insertFirst(2);
        l.insertFirst(8);
        l.insertFirst(17);
        l.display();
    }

    public void insertFirst(int val)
    {
        Node node = new Node(val);
        node.next = head;
        node.prev = null;
        if(head != null){
            head.prev = node;
        }
        head = node;
    }

    public void display()
    {
        Node node = head;
        Node last;
        while(node != null)
        {
            System.out.print(node.val + " ");
            last = node;
            node = node.next;
        }
    }
    public void insertLast(int val)
    {
        Node node = new Node(val);
        Node last = head;

        if(head == null)
        {
            node.prev = null;
            head = node;
            return;
        }

        while(last.next!=null)
        {
            last = last.next;
        }
    }

    public Node find(int value)
    {
        Node node = head;
        while(node != null)
        {
            if(node.val == value)
            {
                return node;
            }
            node = node.next;
        }
        return null;
    }

    public void insert(int after, int val)
    {
        Node p = find(after);

        if(p == null)
        {
            System.out.println("Non Existent");
            return;
        }
        Node node = new Node(val);
        node.next = p.next;
        p.next = node;
        node.prev = p;
        if(node.next != null) {
            node.next.prev = node;
        }
    }

    class Node{

        int val;
        Node next;
        Node prev;

        public Node(int val)
        {
            this.val = val;
        }

        public Node(int val, Node next, Node prev)
        {
            this.val = val;
            this.next = next;
            this.prev = prev;
        }
    }
}
