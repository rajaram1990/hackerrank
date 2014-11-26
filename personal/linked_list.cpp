# include <iostream>
using namespace std;
class Node
{
    public:
    Node* next;
    int data;
    void recursive_add_element(Node* head, int value)
    {
        if (!head) {
            head->data = value;
            head->next = NULL;
            return;
        }
        else{
            head = recursive_add_element(head->next,value)
        }
    }
    Node* add_element(Node* head,int value)
    {
        Node* temp = new Node;
        temp->data = value;
        temp->next = NULL;
        if (head == NULL)
        {
            head = temp;
            return head;
        }
        Node* temp_head = head;
        while (head->next)
            head = head->next;
        head->next = temp;
        return temp_head;
    }
    void print_ll(Node* head)
    {
        while (head)
        {
            cout<<head->data<<endl;
            head = head->next;
        }
    }
};
int main()
{
    Node* head = new Node;
    head = NULL;
    /*
    head = head->add_element(head,1); 
    head = head->add_element(head,2);
    head = head->add_element(head,3);
    head = head->add_element(head,4);
    head = head->add_element(head,5);
    */
    head->recursive_add_element(head,1);
    head->recursive_add_element(head,2);
    cout<<"Printing";
    head->print_ll(head);
}
