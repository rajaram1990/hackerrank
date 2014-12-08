class LinkedList
{
    private LLNode head;
    private int length;
    private String __type;
    
    public LinkedList() {
        __type = "Singly Linked List";
        length = 0;
        head = null;
    }

    public LinkedList(Object first_elem) {
        this();
        add_element(first_elem);
    }

    public void set_head(LLNode head) {
        this.head = head;
    }
    
    public LLNode get_head() {
        return this.head;
    }

    public void add_element (Object data) {
        LLNode temp_node = new LLNode(data,null);
        if (head == null) {
            head = temp_node;
        }
        else {
            LLNode temp_head = this.head;
            while (temp_head.get_next() != null) {
                temp_head = temp_head.get_next();
            }
            temp_head.set_next(temp_node);
        }
        this.length++;
    }

    public boolean add_element(Object data, int position) {
        /** Add Element at specified position */
        LLNode current = this.head;
        int position_counter = 0;
        while (current!=null && current.get_next() != null)
        {
            if (position == 0 || position_counter+1 == position) {
                // -1 is done so that we return one element before
                break;
            }
            else {
                current = current.get_next();
                position_counter++;
            }
        }
        if (position_counter+1 != position && position != 0)
            return false;
        if (position ==0) { //inserting in the first position
            this.add_at_first(data);
        }
        else {
            LLNode temp_node = new LLNode(data);
            // Next is the position where this node has to be inserted
            LLNode saved_next = current.get_next();
            current.set_next(temp_node);
            temp_node.set_next(saved_next);
            this.length++;
        }
        return true;
    }

    public void add_at_first(Object data)
    {
        LLNode temp_node = new LLNode(data);
        if (head == null) {
            head = temp_node;
        }
        else {
            temp_node.set_next(head);
            head = temp_node;
            this.length++;
        }
    }

    public void move_to_first(LLNode to_mode) {
        /** Yet to implement
          * Do not use unless you do cannnot use move_next_to_first
          * since this is much costlier than that
          * Use only if you have no way to find the previous node
          */
    }

    public boolean move_next_to_first(LLNode move_next_node) {
        /** Much cheaper operation than move to first
          * since we already have the previous node's pointer
          */
         LLNode curr_node = move_next_node;
         LLNode next_node = move_next_node.get_next();
         if (next_node == null) {
             System.out.println("Next Node of given node is NULL!");
             return false;
         }
         move_next_node.set_next(curr_node.get_next().get_next());
         next_node.set_next(this.head);
         this.head = next_node;
         return true;
    }

    public void reverse_list() {
        if (this.length <= 1) {
            return; // Reverse of a single elemenet LL is the LL itself
        }
        LLNode saved_head = head;
        LLNode start_point = head.get_next();
        while (saved_head != null && saved_head.get_next() != null) {
            move_next_to_first(saved_head);
        }
    }

    public void sorted_merge(LinkedList list2) {
        /** Given two sorted lists, a and b, merge the the lists such that they
          * remain sorted. Do not copy the nodes' value, instead move the node itself
          * It is okay to destroy list b
          * TO pass : The head of the other node b
        */
        LLNode base_ll = this.get_head();
        LLNode merge_ll = list2.get_head(); // contains ptr of node to be inserted
        if (merge_ll == null) {
            return;
        }
        else if (base_ll == null) {
            this.head = merge_ll;
            return;
        }
        LLNode prev_ptr = null; //stores prev ptr of base list
        while (base_ll != null && merge_ll != null) {
            if ((Integer)base_ll.get_data() >= (Integer)merge_ll.get_data()) {
                if (prev_ptr == null) {
                    // inserting at first position
                    LLNode temp_next = merge_ll.get_next();
                    merge_ll.set_next(base_ll);
                    this.head = merge_ll;
                    base_ll = merge_ll;
                    merge_ll = temp_next;
                }
                else {
                    LLNode saved_next = merge_ll.get_next();
                    prev_ptr.set_next(merge_ll);
                    merge_ll.set_next(base_ll);
                    base_ll = merge_ll;
                    merge_ll = saved_next;
                }
            }
            else {
                prev_ptr = base_ll;
                if (base_ll.get_next() == null)
                    break;
                base_ll = base_ll.get_next();
            }
        }
        if (base_ll.get_next() == null) {
            base_ll.set_next(merge_ll);
        }
        return;
    }

    public void front_back_split(LinkedList[] splits) {
        /** Splits the list into two
          * First half on one list and second half on the other
          * If odd no. of nodes, the odd element on second list
         */
         LLNode slow_ptr = this.head;
         LLNode fast_ptr = this.head;
         if (this.head == null || this.head.get_next() == null) {
             if (splits[0] == null) {
                 splits[0] = new LinkedList(slow_ptr.get_data());
             }
             else {
                 splits[0].add_element(slow_ptr.get_data());
             }
             splits[1] = null;
         }

         while (fast_ptr != null && fast_ptr.get_next() != null) {
             fast_ptr = fast_ptr.get_next().get_next();
             if (splits[0] == null) {
                 splits[0] = new LinkedList(slow_ptr.get_data());
             }
             else {
                 splits[0].add_element(slow_ptr.get_data());
             }
             slow_ptr = slow_ptr.get_next();
         }

         while (slow_ptr !=null) {
            if (splits[1] == null) {
                splits[1] = new LinkedList(slow_ptr.get_data());
            }
            else {
                splits[1].add_element(slow_ptr.get_data());
            }
            slow_ptr = slow_ptr.get_next();
         }
    }          

    public boolean remove_element (Object data) {
        LLNode current = head;
        while (current.get_next() != null) {
            if (current.get_next().get_data() == data) {
                break;
            }
            else {
            current = current.get_next();
            }
        }
        if (current.get_next() == null) {
            if (current.get_data() == data) {
                current = null;
                this.length--;
                return true;
            }
            else {
            return false;
            }
        }
        else {
            LLNode temp_ptr = current.get_next();
            current.set_next(current.get_next().get_next());
            temp_ptr = null;
            this.length--;
        }
        return true;
    }

    public void print_list() {
        LLNode current = this.head;
        while (current!=null) {
            System.out.println(current.get_data());
            current = current.get_next();
        }
    }

    public boolean is_existing(Object data) {
        LLNode current = this.head;
        while (current!=null) {
            if (current.get_data() == data) {
                break;
            }
            else {
                current = current.get_next();
            }
        }
        if (current==null) 
            return false;
        else 
            return true;
    }
}
