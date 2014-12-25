import java.util.*;
public class BinarySearch
{
    /** Accepts a sorted array and searches an element from it in O(logn)
     * complexity
     */
    public static int[] elements = new int[100];
    public static int bsearch(int fromIndex, int toIndex, int elem) throws Exception
    {
        if (toIndex - fromIndex <= 0 && elements[fromIndex] != elem && elements[toIndex] != elem)
            throw new Exception("Value not found!");
        else if (elements[fromIndex] == elem)
            return fromIndex;
        else if (elements[toIndex] == elem)
            return toIndex;
        else if (elem >= elements[fromIndex] && elem <= elements[fromIndex + (toIndex-fromIndex)/2])
        {
            return bsearch(fromIndex,fromIndex + (toIndex-fromIndex)/2,elem);
        }
        else if (elem >= elements[toIndex/2] && elem <= elements[toIndex]) 
            return bsearch(toIndex/2,toIndex,elem);
        else
            throw new Exception("Value not found!");
    } 
    public static void main(String[] args)
    {
        System.out.println("Hello World");
        Scanner sc = new Scanner(System.in);
        int N = Integer.parseInt(sc.nextLine());
        for(int i=0;i<N;i++)
        {
            elements[i] = Integer.parseInt(sc.nextLine());
        }
        try
        {
            int elem = Integer.parseInt(sc.nextLine());
            System.out.println(bsearch(0,N-1,elem));
        }
        catch (Exception e)
        {
            System.out.println("Error");
        }
    }
}
