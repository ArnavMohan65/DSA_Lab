//1.	Write a program to implement Representation of Binary tree with linked list
// import com.sun.source.tree.BinaryTree;

import java.util.*;
import java.lang.*;
public class M_31_BTLL {
    static class Node{
        int val;
        Node next;

        Node(int val) {
            this.val = val;
       }

       Node(int val, Node next)
       {
           this.val = val;
           this.next = next;
       }
    }

    static class BTNode{
        int data;
        BTNode left,right = null;
        BTNode(int data)
        {
            this.data = data;
            left = right = null;
        }
    }

    Node head;
    BTNode root;

    void push(int val)
    {
        Node node = new Node(val);
        node.next = head;
        head = node;
    }

    BTNode BinaryTree(BTNode node)
    {
        Queue<BTNode> q = new LinkedList<BTNode>();
        if(head == null)
        {
            node = null;
            return null;
        }

        node = new BTNode(head.val);
        q.add(node);

        while(head != null)
        {
            BTNode parent = q.peek();

            BTNode leftChild = null,rightChild = null;
            leftChild = new BTNode(head.val);
            q.add(leftChild);
            head = head.next;

            if(head != null)
            {
                rightChild = new BTNode(head.val);
                q.add(rightChild);
                head = head.next;
            }

            parent.left = leftChild;
            parent.right = rightChild;
            q.poll();
        }
        return node;
    }

    void inorderTraversal(BTNode node)
    {
        if (node != null)
        {
            inorderTraversal(node.left);
            System.out.print(node.data + " ");
            inorderTraversal(node.right);
        }
    }

    public static void main(String[] args) {
        M_31_BTLL tree = new M_31_BTLL();
        tree.push(36); /* Last node of Linked List */
        tree.push(30);
        tree.push(25);
        tree.push(15);
        tree.push(12);
        tree.push(10); /* First node of Linked List */
        BTNode node = tree.BinaryTree(tree.root);

        System.out.println("Inorder Traversal of the"+
                " constructed Binary Tree is:");
        tree.inorderTraversal(node);
    }
}
