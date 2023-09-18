import java.util.LinkedList;

public class M_21_linkedList {
    Node head;
    Node tail;
    int size;
    public static void main(String[] args) {
//        LinkedList operation using class and node concept
        LinkedList<Integer> l = new LinkedList<>();
        M_21_linkedList nl = new M_21_linkedList();
        nl.insertFirst(3);
        nl.insertFirst(2);
        nl.insertFirst(8);
        nl.insertFirst(17);
        nl.display();
        nl.insert(69,2);
        nl.display();
        System.out.println(nl.deleteFirst());
//        LinkedList Operations -> using predefined Library
//        l.add(10);
//        l.add(8);
//        l.add(3);
//        l.add(7);
//        l.add(19);
//        System.out.println(l.get(0));
//        l.addFirst(0);
//        l.addLast(100);
//        l.indexOf(10);
//        System.out.println(l.size());
//        System.out.println(l.contains(54));
//        System.out.println(l.peek());
//        l.push(17);
//        System.out.println(l.pop());
//        l.poll();
//        l.remove();


    }

    M_21_linkedList()
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
            size++;
        }
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
        Node node = new Node(value);
        if(tail == null){
            insertFirst(value);
            return;
        }
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
