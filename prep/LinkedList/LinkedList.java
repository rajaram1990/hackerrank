public class LinkedList
{
    private Node head;
    private Node last_ptr;
    public LinkedList(int data)
    {
        this.head = new Node(data);
        this.last_ptr = head;
    }
    public Node get_head()
    {
        return this.head;
    }
    public Node get_last()
    {
        return this.last_ptr;
    }
    public LinkedList(Node[] nodes)
    {
        for(Node node: nodes)
        {
            if (this.head == null)
            {
                this.head = node;
                this.head.set_next(null);
                this.last_ptr = head;
            }
            else
            {
                this.last_ptr.set_next(node);
            }
        }
    }
    public LinkedList(Node node)
    {
        /** Given a node, returns a linkedlist 
          * with the given node as head. It can iterated over
          * as many node as the head element contains 
          */
        this.head = node;
    }
    public void insertLast(int data)
    {
        Node temp_node = new Node(data);
        this.last_ptr.set_next(temp_node);
        this.last_ptr = temp_node;
    }
    public void insertLast(Node node)
    {
        this.last_ptr.set_next(node);
        this.last_ptr = node;
    }
    public void insertFirst(int data)
    {
        Node temp_node = new Node(data);
        Node temp_head = this.head;
        this.head = temp_node;
        temp_node.set_next(temp_head);
    }
    public void printLL()
    {
        Node head = this.head;
        while (head != null)
        {
            System.out.println(head.get_data());
            head = head.get_next();
        }
    }
    public void deleteElement(int data) throws Exception
    {
        Node head = this.head;
        while (head != null && head.get_next() != null)
        {
            if (head.get_data() == data || head.get_next().get_data() == data)
                break;
            head = head.get_next();
        }
        if (head == null || (head.get_next() == null && head.get_data() != data))
            throw new Exception("Element not found");
        else
        {
            if (head.get_data() == data) // First element is the reqd. element
            {
                this.head = head.get_next();
            }
            else // The next node is the element to be deleted
            {
                head.set_next(head.get_next().get_next());
                if (head.get_next() == null) //we have deleted the last elem
                {
                    this.last_ptr = head;
                }
            }
        }
    }
    public void deleteList()
    {
        this.head = null;
        this.last_ptr = null;
    }
    public void sortedInsert(int element)
    {
        Node head = this.head;
        while (head != null && head.get_next() != null && head.get_next().get_data() <= element )
        {
            head = head.get_next();
        }
        Node temp_node = new Node(element);
        temp_node.set_next(head.get_next());
        head.set_next(temp_node);
    }
    public Node frontBackSplit()
    {
        /** Given a LinkedList (referred to by the object's head), splits
          * the LL into two parts, namely the front_half and the back_half
          * Returns : Node pointer to the second split
          */
          Node fast = this.head;
          Node slow = this.head;
          Node prev_ptr = this.head;
          while (fast!=null && fast.get_next()!=null && fast.get_next().get_next()!=null)
          {
              prev_ptr = slow;
              fast = fast.get_next().get_next();
              slow = slow.get_next();
          }
          if (fast != null)
          {
              prev_ptr = slow;
              slow = slow.get_next(); // Since the first split should have two nodes
          }
          prev_ptr.set_next(null);
          return slow;
    }
    public void sortedMerge(LinkedList toMerge)
    {
        /** Given a LinkedList as a param, merges the toMerge list
          * to the existing list pointed to, by the current object
          * Assumes that, both the LLs are individually sorted
          */
        Node base_head = this.head;
        Node merge_head = toMerge.head;
        Node prev_base = null;
        while (base_head != null && merge_head != null)
        {
            if (merge_head.get_data() <= base_head.get_data())
            {
                // Move merge_head to base_head
                Node temp_node = merge_head.get_next();
                merge_head.set_next(base_head);
                if (base_head == this.head)//first element insert
                {
                    this.head = merge_head; 
                    base_head = merge_head;
                }
                else
                {
                    prev_base.set_next(merge_head);
                    prev_base = merge_head;
                }
                merge_head = temp_node;
            }
            else
            {
                prev_base = base_head;
                base_head = base_head.get_next();
            }
        }
        if (base_head == null)
        {
            prev_base.set_next(merge_head);
        }
    }
}
