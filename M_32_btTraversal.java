import java.util.*;
import java.lang.*;
public class M_32_btTraversal {
    static class Node{
        int val;
        Node left;
        Node right;

        Node(int val)
        {
            this.val = val;
        }
    }

    Node root;

    M_32_btTraversal(){}

    public void populate(Scanner scanner)
    {
        System.out.println("Enter the root Node : ");
        int val = scanner.nextInt();
        root  = new Node(val);
        populate(scanner, root);
    }

    private void populate(Scanner scanner,Node node)
    {
        System.out.println("Do you want to enter left of : " + node.val);
        boolean left = scanner.nextBoolean();
        if(left)
        {
            System.out.println("Enter the value left of " + node.val);
            int val = scanner.nextInt();
            node.left = new Node(val);
            populate(scanner, node.left);
        }

        System.out.println("Do you want to enter right of : " + node.val);
        boolean right = scanner.nextBoolean();
        if(right)
        {
            System.out.println("ENter the value right of " + node.val);
            int val = scanner.nextInt();
            node.right = new Node(val);
            populate(scanner, node.right);
        }
    }

    public void display()
    {
        display(this.root,"");
    }

    private void display(Node node,String indent)
    {
        if(node == null)
        {
            return;
        }
        System.out.println(indent + node.val);
        display(node.left,indent + " \t ");
        display(node.right,indent + " \t ");
    }

//Traversals
//  PRE-ORDER NODE - LEFT - RIGHT
//  IN-ORDER  LEFT - NODE - RIGHT
//  POST-ORDER LEFT - RIGHT - NODE

    public void preOrder()
    {
        preOrder(root);
    }

    private void preOrder(Node node)
    {
        if(node == null)
        {
            return;
        }
        System.out.println(node.val + " ");
        preOrder(node.left);
        preOrder(node.right);
    }public void inOrder()
    {
        inOrder(root);
    }

    private void inOrder(Node node)
    {
        if(node == null)
        {
            return;
        }
        inOrder(node.left);
        System.out.println(node.val + " ");
        inOrder(node.right);
    }
    public void postOrder()
    {
        postOrder(root);
    }

    private void postOrder(Node node)
    {
        if(node == null)
        {
            return;
        }
        postOrder(node.left);
        postOrder(node.right);
        System.out.println(node.val + " ");
    }

    public static void main(String[] args) {

    }
}
