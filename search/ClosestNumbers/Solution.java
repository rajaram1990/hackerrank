import java.util.*;
public class Solution
{
    public static void main(String[] args)
    {
        int N;
        ArrayList<Integer> al = new ArrayList<Integer>();
        Scanner sc = new Scanner(System.in);
        N = Integer.parseInt(sc.nextLine());
        String str = sc.nextLine();
        String[] splits = str.split(" ");
        for (String split: splits)
        {
            al.add(Integer.parseInt(split));
        }
        Collections.sort(al);
        int min_diff = Integer.MAX_VALUE;
        ArrayList<Integer>index1 = new ArrayList<Integer>();
        int temp_diff;
        Object[] al_array = al.toArray();
        for (int i=0;i<N-1;i++) {
            temp_diff = Math.abs((Integer)al_array[i]- (Integer)al_array[i+1]);
            if (temp_diff < min_diff)
                min_diff = temp_diff;
        }
        for(int i=0;i<N-1;i++) {
            temp_diff = Math.abs((Integer)al_array[i]- (Integer)al_array[i+1]);
            if (temp_diff==min_diff)
                index1.add(i);
        }
        Iterator<Integer> alitr = index1.iterator();
        while (alitr.hasNext()) {
            int temp_idx = alitr.next();
            System.out.format("%d %d ",(Integer)al_array[temp_idx],(Integer)al_array[temp_idx+1]);
        }
        System.out.format("\n");
    }
}
