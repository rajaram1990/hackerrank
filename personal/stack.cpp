# include <iostream>
# define MAX_LEN 10
using namespace std;
class Stack
{
    private:
    int stk_obj[MAX_LEN];
    int cur_pos;
    public:
    Stack()
    {
        cur_pos = 0;
    }
    int pop()
    {
        cout<<"POP"<<endl;
        if (cur_pos >=0)
        {
            int _temp;
            cout<<"cur_pos"<<cur_pos<<endl;
            _temp = stk_obj[cur_pos];
            cout<<"Popping "<<stk_obj[cur_pos]<<endl;
            cur_pos--;
            return _temp; 
        }
        else
        {
            cout<<"Underflow";
            // Do exception handling here
        }
        return 0;
    }
    void push(int value)
    {
        cout<<"PUSH"<<endl;
        if (cur_pos < MAX_LEN)
        {
            cout<<"cur_pos"<<cur_pos<<endl;
            stk_obj[cur_pos]=value;
            cur_pos++;
        }
        else
        {
            cout<<"overflow";
            // Do Exception handling here!
        }
    }
};
int main()
{
    cout<<"Hello World";
    Stack stack;
//    Stack* stack = new Stack();
// Remember to delete if you use new here
    stack.push(1);
    stack.push(2);
    stack.push(3);
    stack.push(4);
    cout<<endl;
    cout<<"popping"<<stack.pop()<<endl;
    cout<<stack.pop()<<endl;
    cout<<stack.pop()<<endl;
    cout<<stack.pop()<<endl;
    cout<<stack.pop()<<endl;
    cout<<stack.pop()<<endl;
    return 0;
}
