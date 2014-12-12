import java.util.*;
class TestCase {
    /** The class to store the result of the ice cream problem. 
      * Has indexes of the two flavours that can be bought with M Dollars
    */
    public int M; //Amount in $
    public int N; //No. of flavours available
    public int outputIndex1;
    public int outputIndex2;
    public ArrayList<Integer> C = new ArrayList<Integer>(N);//Cost of each flavour
    public TestCase(int M, int N, ArrayList<Integer> C)
    {
        this.init(M,N,C);
    }
    public void init(int M, int N, ArrayList<Integer> C)
    {
        this.M = M;
        this.N = N;
        this.C = C;
    }
    public void get_flavours()
    /** For the given class, finds out the two different
        flavours that can be bought with M Dollars
    */
    {
        int temp_cost = 0;
        Object[] C = this.C.toArray();
        for (int i=0; i<C.length; i++)
        {
            temp_cost = M - (Integer)C[i];
            for(int j=0; j<C.length; j++)
            {
                if (i!=j)
                {
                    if ((Integer)C[j]==temp_cost)
                    {
                        this.outputIndex1 = i+1; // To compensate for zero indexing
                        this.outputIndex2 = j+1;
                        return;
                    }
                }
            }
        }
    }
}
public class Solution {
    public static int T;
    public static void main(String[] args) {
        /* N -> No. of flavours available (int)
         * M -> Amount in $
         * T -> No. of test cases
         * C -> Cost of flavours (arraylist) */
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        ArrayList<Integer> costs = new ArrayList<Integer>();
        TestCase[] tc = new TestCase[T];
        for (int i=0; i<T; i++)
        {
            int M = Integer.parseInt(sc.nextLine());
            int N = Integer.parseInt(sc.nextLine());
            String cost_flavours = sc.nextLine();
            String[] cost_splits = cost_flavours.split(" ");
            costs.clear();
            for (String c : cost_splits)
                costs.add(Integer.parseInt(c));
            tc[i] = new TestCase(M,N,costs);
            tc[i].get_flavours();
        }
        for (int i=0; i<T; i++)
        {
            System.out.format("%d %d\n",tc[i].outputIndex1, tc[i].outputIndex2);
        }
        
    }
}
