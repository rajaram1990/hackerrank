import java.util.ArrayList;
import java.util.Scanner;
class TestCase {
    /** The class to store the result of the ice cream problem. 
      * Has indexes of the two flavours that can be bought with M Dollars
    */
    public int M; //Amount in $
    public int N; //No. of flavours available
    public int outputIndex1;
    public int outputIndex2;
    public int[] C = new int[N];//Cost of each flavour
    public TestCase(int M, int N, int[] C)
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
        for (int i=0; i<C.length; i++)
        {
            temp_cost = M - C[i];
            System.out.format("M %d \n",M);
            System.out.format("C[i] %d \n",C[i]);
            System.out.format("temp_cost %d \n",temp_cost);
            for(int j=0; j<C.length; j++)
            {
                if (i!=j)
                {
                    if (C[j]==temp_cost)
                    {
                        this.outputIndex1 = i;
                        this.outputIndex2 = j;
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
        int T = sc.nextInt();
        int M,N;
        TestCase[] tc = new TestCase[T];
        for(int i=0; i<T; i++)
        {
            M = sc.nextInt();
            N = sc.nextInt();
            int[] C = new int[N];
            for(int j=0; j<N; j++)
                C[i] = sc.nextInt();
            System.out.println("Hello");
            System.out.println(C);
            tc[i] = new TestCase(M,N,C);
        }
        for (int i=0; i<T; i++)
        {
            tc[i].get_flavours();
            System.out.format("%d %d\n",tc[i].outputIndex1, tc[i].outputIndex2);
        }
        
    }
}
