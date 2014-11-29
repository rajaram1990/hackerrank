import java.util.Scanner;
class Main
{
    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList(10);
        ll.add_element(20); 
        ll.add_element(30);
        ll.add_element(40);
        ll.add_at_first(50);
        System.out.println("Add status "+ll.add_element(60,3));
        System.out.println("Add status "+ll.add_element(70,0));
//        System.out.println("Status : "+ll.remove_element(40));
        System.out.println("Is Existing : "+ll.is_existing(50));
        ll.print_list();
        System.out.println("Reversing the LL");
        ll.reverse_list();
        ll.print_list();
        System.out.println("splitting the list into two sub lists");
        LinkedList[] split_lls = new LinkedList[2];
        ll.front_back_split(split_lls);
        split_lls[0].print_list();
        System.out.println("List 2");
        split_lls[1].print_list();
        // Testing sorted merge
        LinkedList list1 = new LinkedList(4);
        list1.add_element(9);
        list1.add_element(13);
        list1.add_element(17);
        list1.add_element(27);
        list1.add_element(32);
        LinkedList list2 = new LinkedList(2);
        list2.add_element(10);
        list2.add_element(11);
        list2.add_element(12);
        list2.add_element(15);
        list2.add_element(16);
        list2.add_element(22);
        list2.add_element(29);
        list2.add_element(34);
        list1.sorted_merge(list2);
        System.out.println("List 1 Sorted Merge");
        list1.print_list();
    }
}
