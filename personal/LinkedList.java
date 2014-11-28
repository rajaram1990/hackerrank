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

    public boolean remove_element (Object data) {
        LLNode current = head;
        while (true) {
        if (current.get_next() == null || current.get_next().get_data() == data) {
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
        while (current.get_data() != data || current!=null) {
            current = current.get_next();
        }
        if (current==null) 
            return false;
        else 
            return true;
    }
}
