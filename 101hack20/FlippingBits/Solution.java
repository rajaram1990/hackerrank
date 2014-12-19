import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int T = Integer.parseInt(sc.nextLine());
        int[] qs = new int[T];
        int[] as = new int[T];
        int max_int = (Integer.MAX_VALUE)*2+3;
        for(int i=0;i<T;i++)
        {
            qs[i] = Integer.parseInt(sc.nextLine());
            as[i] = qs[i]^max_int;
        }
//        System.out.println("MAX");
//        System.out.println(Integer.MAX_VALUE);
        for (int i=0;i<T;i++)
        {
            System.out.println(~qs[i]);
        }
    }
}
