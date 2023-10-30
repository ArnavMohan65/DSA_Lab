//1.	Write a Program to implement single linked list and its operations
import java.util.LinkedList;

public class M_24_QueueLL {
    Node head;
    Node tail;
    int size;
    public static void main(String[] args) {
//        LinkedList operation using class and node concept
        LinkedList<Integer> l = new LinkedList<>();
        M_24_QueueLL nl = new M_24_QueueLL();
        nl.insertFirst(3);
        nl.insertFirst(2);
        nl.insertFirst(5);
        nl.insertFirst(8);
        nl.display();
        System.out.println();
        System.out.println("enqueue");
        nl.enqueue(17);
        nl.display();
        System.out.println("dequeue");
        nl.deque();
        nl.display();
//        nl.insertLast(19);
//        nl.insertFirst(17);
//        nl.display();
    }

//    This operation adds a new node after the rear and moves the rear to the next node #basically insertLast()
    public void enqueue(int val)
    {
        if (tail == null) {
            insertFirst(val);
            return;
        }
        Node node = new Node(val);
        tail.next = node;
        tail = node;
        size++;
    }

//    This operation removes the front node and moves the front to the next node #basically deleteFirst()
    public void deque()
    {
        if (head == null) {
            tail = head;
            return;
        }
        Node node = head;
        head = node.next;
        size --;
        if(head == null)
        {
            tail = head = null;
        }
    }

    M_24_QueueLL()
    {
        this.size = 0;
    }

    public int deleteLastElement()
    {
        if(size <= 1)
        {
            return deleteFirst();
        }
        Node secondLast = get(size - 2);
        int val = tail.value;
        tail = secondLast;
        tail.next = null;
        return val;
    }

    public Node get(int index)
    {
        Node node = head;
        for(int i = 0;i < index; i++)
        {
            node = node.next;
        }
        return node;
    }

    public void insertFirst(int value)
    {
        Node node = new Node(value);

        node.next = head;
        head = node;
        if(tail == null){
            tail = head;
        }
        size++;
    }

    public int deleteFirst()
    {
        int val = head.value;
        head = head.next;
        if(head == null)
            tail = null;
        size--;

        return val;
    }

    public int delete(int index){
        if(index == 0)
        {
            deleteFirst();
        }
        if(index == size - 1)
        {
            deleteLastElement();
        }

        Node prev = get(size - 1);
        int val = prev.next.value;
        prev.next = prev.next.next;
        return val;
    }
    public void insertLast(int value)
    {
        if(tail == null){
            insertFirst(value);
            return;
        }
        Node node = new Node(value);
        tail.next = node;
        tail = node;
        size++;
    }

    public void insert(int value,int index)
    {
        if(index == 0)
        {
            insertFirst(value);
            return;
        }
        if(index == size)
        {
            insertLast(value);
            return;
        }
        Node temp = head;
        for(int i = 0;i < index; i++)
        {
            temp = temp.next;
        }
//        temp = head;
//        temp.next = temp.next.next;
        Node node = new Node(value,temp.next);
        temp.next = node;

        size++;

    }
    public void display(){
        Node temp = head;
        while(temp != null)
        {
            System.out.print(temp.value + " ");
            temp = temp.next;
        }
    }

    private class Node{
        int value;
        Node next;

        public Node(int value)
        {
            this.value = value;
        }

        public Node(int value, Node next)
        {
            this.value = value;
            this.next = next;
        }
    }

}
