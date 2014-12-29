public class Main
{
    public static void main(String[] args)
    {
        LinkedList ll = new LinkedList(10);
        ll.insertFirst(7);
        ll.insertLast(20);
        ll.insertLast(24);
        ll.insertLast(27);
        ll.insertFirst(4);        
        ll.printLL();
        try
        {
            ll.deleteElement(27);
            System.out.println(ll.get_last().get_data());
        }
        catch (Exception e)
        {
            System.out.println("Element not found");
        }
        ll.insertLast(29);
        ll.insertLast(32);
        System.out.println("After Delete");
        ll.printLL();
        System.out.println("Sorted insert");
        ll.sortedInsert(22);
        ll.sortedInsert(14);
        ll.printLL();
        /*System.out.println("Splitting into two lists");
        Node back = ll.frontBackSplit();
        System.out.println("List 1");
        ll.printLL();
        System.out.println("List 2");
        LinkedList backList = new LinkedList(back);
        backList.printLL(); */
        LinkedList list2 = new LinkedList(1);
        list2.insertLast(2);
        list2.insertLast(3);
        list2.insertLast(5);
        list2.insertLast(6);
        list2.insertLast(9);
        list2.insertLast(17);
        list2.insertLast(21);
        list2.insertLast(38);
        list2.insertLast(39);
        //ll.sortedMerge(list2);
        System.out.println("Sorted Merge");
        ll.printLL();
        LinkedList list3 = new LinkedList(24);
        list3.insertFirst(10);
        list3.insertFirst(11);
        list3.insertFirst(14);
        list3.insertLast(22);
        list3.insertLast(17);
        System.out.println("Printing Before Merge Sort");
        list3.printLL();
//        list3.insertionSort();
 //       list3.printLL();
        System.out.println("Printing After Merge Sort");
        LinkedList list4 = list3.mergeSort(list3);
        list4.printLL();
        LinkedList list5 = new LinkedList(7);
        list5.insertLast(7);
        list5.insertLast(4);
        list5.insertLast(3);
        list5.insertLast(6);
        list5.insertLast(2);
        list5.insertLast(8);
        LinkedList list6 = new LinkedList(8);
        list6.insertLast(9);
        list6.insertLast(6);
        list6.insertLast(4);
        list6.insertLast(2);
        list6.insertLast(9);
        list6.insertLast(3);
        LinkedList list7 = list5.add_numbers(list6);
        System.out.println("Addition :");
        list7.printLL();
        System.out.println("Reverse :");
        list7.reverse();
        list7.printLL();
    }
}
