import java.util.*;
public class Main
{
    public static void main(String args[])
    {
        try
        {
            BinarySearchTree bst = new BinarySearchTree(5);
            bst.addElement(7);
            bst.addElement(8);
            bst.addElement(3);
            bst.addElement(4);
            bst.addElement(2);
            bst.addElement(1);
            bst.addElement(6);
            bst.printInorder();
            System.out.println("PostOrder");
            bst.printPostorder();
            System.out.println("PreOrder");
            bst.printPreorder();
            System.out.println("Reverse Sorted");
            bst.reverseSorted();
            BstNode x = bst.searchElement(2);
            System.out.println(x.getData());
        }
        catch (Exception ex)
        {
            System.out.println("Duplicate Key");
        }
    }
}
