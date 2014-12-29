public class LinkedList
{
    private Node head;
    private Node last_ptr;
    public LinkedList()
    {
        this.head = null;
        this.last_ptr = null; 
    }
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
        if (this.head == null)
        {
            this.head = temp_node;
            this.last_ptr = temp_node;
        }
        else
        {
            this.last_ptr.set_next(temp_node);
            this.last_ptr = temp_node;
        }
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
        if (this.head == null)
        {
            this.last_ptr = temp_node;
        }
        else
        {
            temp_node.set_next(temp_head);
        }
        this.head = temp_node;
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
    public LinkedList mergeSort(LinkedList toSort)
    {
        if (toSort.head != null && toSort.head.get_next() == null)
        {
            return toSort;
        }
        LinkedList list2 = new LinkedList(toSort.frontBackSplit());
        LinkedList list1 = toSort;
        list1.mergeSort(list1);
        list1.mergeSort(list2);
        list1.sortedMerge(list2);
        return list1;
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
    public void insertionSort()
    {
        /** Sorts the given list (represented by the current object) by doing
          * an insertion sort
          */
        if (this.head == null)
            return;
        Node sortedList = this.head;
        Node unsorted = this.head.get_next();
        //Detach the two sublists!
        sortedList.set_next(null);
        Node prev_sorted = null;
        while (unsorted != null)
        {
            Node temp_sorted = sortedList;
            while (temp_sorted != null && unsorted.get_data() > temp_sorted.get_data())
            {
                prev_sorted = temp_sorted;
                temp_sorted = temp_sorted.get_next();
            }
            if (prev_sorted == null ) // to insert first element 
            {
                Node temp_next = unsorted.get_next();
                unsorted.set_next(temp_sorted);
                sortedList = unsorted;
                unsorted = temp_next; 
            }
            else
            {
                Node temp_next = unsorted.get_next();
                unsorted.set_next(temp_sorted);
                prev_sorted.set_next(unsorted);
                unsorted = temp_next;
            }
            LinkedList temp = new LinkedList(sortedList);
            temp.printLL();
       }
       this.head = sortedList;
    }
    public int getLength()
    {
        /** Gives the length of the linked List
        */
        Node temp_head = this.head;
        int count = 0;
        while (temp_head != null)
        {
            count++;
            temp_head = temp_head.get_next();
        }
        return count;
    }
    public LinkedList add_numbers(LinkedList toAdd)
    {
        /** Adds number represented in the linkedlist this
            and the one represented by add_numbers. Each node
            int the linkedlist represents a digit
          */
        LinkedList sum = new LinkedList();
        LinkedList carry = new LinkedList();
        int digitsDiff = this.getLength() - toAdd.getLength();
        // Add zeros for digits difference
        if (digitsDiff < 0)
        {
            digitsDiff = digitsDiff - 2*digitsDiff;
            while (digitsDiff > 0)
            {
                this.insertFirst(0);
                digitsDiff--;
            }
        }
        else
        {
            while (digitsDiff > 0)
            {
                toAdd.insertFirst(0);
                digitsDiff--;
            }
        }
        int temp_var = 0;
        Node temp_head = this.head;
        Node temp_toadd = toAdd.get_head();
        // Adding the two arrays
        System.out.println("Just before addition");
        System.out.println("List 1");
        this.printLL();
        System.out.println("List 2");
        toAdd.printLL();
        while (temp_head != null)
        {
            temp_var = temp_head.get_data() + temp_toadd.get_data();
            carry.insertFirst(temp_var/10);
            sum.insertFirst(temp_var%10);
            temp_head = temp_head.get_next();
            temp_toadd = temp_toadd.get_next();
        }
        // Moving all elements of carry by one element
        carry.insertFirst(0);
        sum.insertLast(0);
        System.out.println("Printing SUM List");
        sum.printLL();
        System.out.println("Printing Carry");
        carry.printLL();
        System.out.println(sum.get_last().get_data());
        // Adding sum and carry
        Node temp_sum = sum.get_head();
        Node temp_carry = carry.get_head();
        while (temp_sum != null) 
        {
            int temp_int;
            temp_int = temp_sum.get_data() + temp_carry.get_data();
            if (temp_int >= 10)
            {
                if (temp_carry.get_next() != null)
                {
                    temp_carry.get_next().set_data(temp_carry.get_next().get_data()+1);
                    temp_int = temp_int%10;
                }
            }
            temp_sum.set_data(temp_int);
            temp_sum = temp_sum.get_next();
            temp_carry = temp_carry.get_next();
        }
        //sum.reverse();
        return sum;
     }

    public void reverse()
    {
        /** Reverses the LinkedList represented by this object */
        if (head == null || head.get_next() == null)
            return;
        Node rev_head = this.get_head();
        Node unrev_head = this.get_head().get_next();
        rev_head.set_next(null);
        while(unrev_head != null)
        {
            Node savedNext = unrev_head.get_next();
            unrev_head.set_next(rev_head);
            rev_head = unrev_head;
            unrev_head = savedNext;
        }
        this.head = rev_head;
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
