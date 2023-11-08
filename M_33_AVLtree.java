//3.	Create AVL Tree (Balanced BST) for the following sequence 3,2,1,4,5,6,7,8,9
public class M_33_AVLtree {
    public static class Node{
        int val;
        Node right;
        Node left;
        int height;
        Node(int val)
        {
            this.val = val;
        }
    }

    Node root;

    M_33_AVLtree(){}

    public int height()
    {
        return height(root);
    }
    int height(Node node)
    {
        if(node == null)
        {
            return -1;
        }
        return node.height;
    }

    void insert(int val)
    {
        root = insert(val,root);
    }

    private Node insert(int value,Node node)
    {
        if(node == null)
        {
            node = new Node(value);
            return node;
        }

        if(value < node.val){
            node.left = insert(value,node.left);
        }

        if(value > node.val){
            node.right = insert(value,node.right);
        }

        node.height = Math.max(height(node.left),height(node.right)) + 1;

        return rotate(node);
    }

    private Node rotate(Node node)
    {
        if(height(node.left) - height(node.right)  > 1)
        {//left heavy
            if(height(node.left.left) - height(node.left.right) > 0)
            {//left left case
                return rightRotate(node);
            }

            if(height(node.left.left) - height(node.left.right) < 0)
            {//left right case
                node.left = leftRotate(node.left);
                return rightRotate(node);
            }
        }

        if(height(node.left) - height(node.right)  < -1)
        {//right heavy
            if(height(node.right.left) - height(node.right.right) < 0)
            {//right right case
                return leftRotate(node);
            }

            if(height(node.right.left) - height(node.right.right) > 0)
            {//right left case
                node.right = rightRotate(node.right);
                return leftRotate(node);
            }
        }

        return node;
    }

    public Node rightRotate(Node p)
    {
        Node c = p.left;
        Node t = c.right;

        c.right = p;
        p.left = t;

        p.height = Math.max(height(p.left),height(p.right) + 1);
        c.height = Math.max(height(c.left),height(c.right) + 1);

        return c;
    }

    public Node leftRotate(Node c)
    {
        Node p = c.right;
        Node t = p.left;

        p.left = c;
        c.right = t;

        p.height = Math.max(height(p.left), height(p.right) + 1);
        c.height = Math.max(height(c.left), height(c.right) + 1);

        return p;
    }

    public void populate(int[] nums)
    {
        for (int num : nums) {
            this.insert(num);
        }
    }

    public void display()
    {
        display(this.root,"Root Node: ");
    }
    private void display(Node node,String details)
    {
        if(node == null)
        {
            return;
        }

        System.out.println(details + node.val);
        display(node.left,"Left Node of " + node.val + " : ");
        display(node.right,"Right Node of " + node.val + " : ");
    }

    public static void main(String[] args) {
        int[] nums = {3,2,1,4,5,6,7,8,9};
        M_33_AVLtree t = new M_33_AVLtree();
        t.populate(nums);
        t.display();
    }
}
