import java.util.*;
import java.math.*;
public class Solution
{
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
                BigInteger mod, temp_j, temp;
                mod = new BigInteger("1000000000");
                temp_j = new BigInteger(Integer.toString(j));
                temp = temp_j.modInverse(mod);
                facts.put(j,facts.get(j-1)*(n[i]-j+1)*temp.longValue());
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
