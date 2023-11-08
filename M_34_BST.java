//Get 20 numbers from user and store in array. Create a Binary search tree in the      sequence of input. Perform the following:
//        (i) Insert an element into BST.
//        (ii) Delete an element from BST.
//        (iii) Search an element in BST.
public class M_34_BST {

    public static class Node{
        int val;
        Node left;
        Node right;
        int height;
        Node(int val)
        {
            this.val = val;
        }
        int getValue()
        {
            return val;
        }
    }

    public Node root;
    M_34_BST(){}

    int height(Node node)
    {
        if(node == null)
        {
            return -1;
        }
        return node.height;
    }

    public void insert(int val)
    {
        root = insert(val,root);
    }

    private Node insert(int val,Node node)
    {
        if(node == null)
        {
            node =  new Node(val);
            return node;
        }

        if(val < node.val)
        {
            node.left = insert(val,node.left);
        }

        if(val > node.val)
        {
            node.right = insert(val,node.right);
        }

        node.height = Math.max(height(node.left),height(node.right)) + 1;

        return node;
    }


    public void display()
    {
        display(this.root,"Root Node : ");
    }

    private void display(Node node,String details){
        if(node == null)
        {
            return;
        }
        System.out.println(details + node.val);
        display(node.left,"Left child of " + node.val + " : ");
        display(node.right,"Right child of " + node.val + " : ");
    }

    //Deleting a node in BST
    public boolean delete(int value)
    {
        return delete(root,value) != null ? true : false;
    }

    private Node delete(Node root,int value){
        if(root == null) {
            return root;
        }else if(root.val > value){
            root.left = delete(root.left, value);
        }else if(root.val < value){
            root.right = delete(root.right, value);
        }
        else{
            if(root.left == null){
                return root.right;
            }else if(root.right == null){
                return root.left;
            }

            root.val = findMin(root.right);

            root.right = delete(root.right,root.val);
        }
        return root;
    }

    private int findMin(Node node){
        int min = node.val;

        while(node.left != null){
            min = node.left.val;
            node = node.left;
        }
        return min;
    }
    public Node Search(Node root,int value)
    {
        if(root == null || root.val == value)
        {
            return root;
        }

        if(value < root.val)
        {
            return Search(root.left,value);
        }else{
            return Search(root.right,value);
        }
    }

    public void populate(int[] nums)
    {
        for(int num : nums)
        {
            this.insert(num);
        }
    }
}