import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int V = Integer.parseInt(sc.nextLine());
        int n = Integer.parseInt(sc.nextLine());
        String temp_str = sc.nextLine();
        ArrayList<Integer> values = new ArrayList<Integer>();
        String[] temp_values = temp_str.split(" ");
        for (String temp_value: temp_values)
            values.add(Integer.parseInt(temp_value));
        System.out.println(values.indexOf(V));
    }
}
