import java.util.*;
public class Solution
{
    public static long fast_pow(long base, long n,long M) 
    {
        if(n==0)
            return 1;
        if(n==1)
            return base;
        long halfn = fast_pow(base,n/2,M);
        if(n%2==0)
            return ( halfn * halfn ) % M;
        else
            return ( ( ( halfn * halfn ) % M ) * base ) % M;
    }
    public static long findMMI_fermat(long n,long M)
    {
        return fast_pow(n,M-2,M);
    }
    public static void main(String[] args)
    {
        HashMap<Integer,Long> facts = new HashMap<Integer,Long>();
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        long[] n = new long[T];
        for (int i=0;i<T;i++)
        {
            n[i] = Integer.parseInt(sc.nextLine());
        }
        for(int i=0;i<T;i++)
        {
            facts.put(0,1L);
            facts.put(1,n[i]);
            for(int j=2;j<n[i]/2+1;j++)
            {
                facts.put(j,facts.get(j-1)*(n[i]-j+1)/j);
            }
            for(int j=0;j<=n[i];j++)
            {
                if (facts.containsKey(j))
                    System.out.format("%d ",facts.get(j));
                else
                    System.out.format("%d ",facts.get((int)n[i]-j));
            }
            System.out.format("\n");
            facts.clear();
        }
        
    }
}
