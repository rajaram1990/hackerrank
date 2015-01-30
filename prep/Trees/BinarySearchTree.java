import java.util.ArrayList;
class BinarySearchTree
{
    public BstNode head;
    public BinarySearchTree(int data)
    {
        this.head = new BstNode(data);
    }
    public BinarySearchTree()
    {
        this.head = null;
    }
    public void addElement(int data) throws Exception
    {
        addElement(data, this.head);
    }
    public BstNode addElement(int data, BstNode head_ptr) throws Exception
    {
        if (head_ptr == null)
        {
            BstNode temp_node = new BstNode(data);
            return temp_node;
        }
        try
        {
            BstNode result;
            if (data > head_ptr.getData())
            {
                result = this.addElement(data,head_ptr.getRight());
                head_ptr.setRight(result);
            }
            else if (data < head_ptr.getData())
            {
                result = this.addElement(data,head_ptr.getLeft());
                head_ptr.setLeft(result);
            }
            else
                throw new Exception("Duplicate Key");
            return head_ptr;
        }
        catch (Exception ex)
        {
            System.out.println("Duplicate Key");
            return null;
        }
    }
    public BstNode searchElement(int data) throws Exception
    {
        return searchElement(data, this.head);
    }
    public void printInorder()
    {
        printInorder(this.head);
    }
    public void reverseSorted()
    {
        reverseSorted(this.head);
    }
    public void reverseSorted(BstNode head_ptr)
    {
        if (head_ptr == null)
            return;
        reverseSorted(head_ptr.getRight());
        System.out.println(head_ptr.getData());
        reverseSorted(head_ptr.getLeft());
    }
    public void printInorder(BstNode head_ptr)
    {
        if (head_ptr==null)
            return;
        printInorder(head_ptr.getLeft());
        System.out.println(head_ptr.getData());
        printInorder(head_ptr.getRight());
    }
    public void printPostorder()
    {
        printPostorder(this.head);
    }
    public void printPostorder(BstNode head_ptr)
    {
        if (head_ptr==null)
            return;
        printPostorder(head_ptr.getRight());
        printPostorder(head_ptr.getLeft());
        System.out.println(head_ptr.getData());
    }
    public void printPreorder()
    {
        printPreorder(this.head);
    }
    public void printPreorder(BstNode root)
    {
        if (root==null)
            return;
        System.out.println(root.getData());
        printPreorder(root.getLeft());
        printPreorder(root.getRight());
    }
    public boolean hasPathSum (int data, BstNode head_ptr)
    {
        if (head_ptr == null)
            return data==0;
        else
        {
            return hasPathSum(data - head_ptr.getData(), head_ptr.getLeft()) || hasPathSum(data - head_ptr.getData(), head_ptr.getRight());
        }
    }
    public void printPaths()
    {
        BstNode head_ptr = this.head;
        ArrayList<Integer> al = new ArrayList<Integer>();
        printPaths(head_ptr,al);
    }
    public void printPaths(BstNode head_ptr, ArrayList<Integer> paths)
    {
        ArrayList<Integer> temp_paths = new ArrayList<Integer>(paths);
        temp_paths.add(head_ptr.getData());
        if (head_ptr.getLeft() != null)
            printPaths(head_ptr.getLeft(),temp_paths);
        if (head_ptr.getRight() != null)
            printPaths(head_ptr.getRight(),temp_paths);
        if (head_ptr.getRight() == null && head_ptr.getLeft() == null)
            System.out.println(temp_paths);
    }

    public BstNode searchElement(int data, BstNode head_ptr) throws Exception
    {
        try
        {
            if (head_ptr==null)
                throw new Exception("Element not found");
            if (data < head_ptr.getData())
                return searchElement(data, head_ptr.getLeft());
            else if (data > head_ptr.getData())
                return searchElement(data, head_ptr.getRight());
            else
                return head_ptr;
        }
        catch (Exception ex)
        {
            System.out.println("Element not found");
            return null;
        }
    }
}
