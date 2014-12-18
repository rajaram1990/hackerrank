import java.util.Scanner;
class Solution
{
    public static void main(String[] args)
    {
        Scanner sc = new Scanner(System.in);
        int S = Integer.parseInt(sc.nextLine());
        int[] elems = new int[1000];
        String str = sc.nextLine();
        String[] temp_str = str.split(" ");
        for (int i=0; i<S; i++)
            elems[i] = Integer.parseInt(temp_str[i]);
        int elem_to_move = elems[S-1];
        for (int i=S-1;i>=0;i--) {
                if (i==0)
                    elems[i]=elem_to_move;
                else if (elem_to_move < elems[i-1]) {
                        elems[i] = elems[i-1];
                }
                else {
                    elems[i] = elem_to_move;
                    for (int j=0;j<S;j++)
                        System.out.format("%d ",elems[j]);
                    break;
                }
                for (int j=0;j<S;j++)
                    System.out.format("%d ",elems[j]);
                System.out.format("\n");
        }
        System.out.format("\n");
    }
}
