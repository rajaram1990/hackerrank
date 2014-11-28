class LLNode
/*
 * Class that defines the node of a singly linked list
 */
{
    private Object data;
    private LLNode next;
    public LLNode(Object data) {
        this.data = data;
    }

    public LLNode(Object data, LLNode next) {
        this(data);
        this.next = next;
    }
    
    public Object get_data(){
        return this.data;
    }

    public void set_data(Object data){
        this.data = data;
    }

    public LLNode get_next(){
        return this.next;
    }

    public void set_next(LLNode next_node){
        this.next = next_node;
    }
}
