public class BstNode
{
    private int data;
    private BstNode left;
    private BstNode right;
    public boolean visited;
    public BstNode(int data)
    {
        this.data = data;
        left = null;
        right = null;
    }

    public int getData()
    {
        return this.data;
    }

    public BstNode getLeft()
    {
        return this.left;
    }

    public BstNode getRight()
    {
        return this.right;
    }

    public void setRight(BstNode node)
    {
        this.right = node;
    }

    public void setLeft(BstNode node)
    {
        this.left = node;
    }
}

