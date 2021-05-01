/*
Java solution for the problem Ignore the Garbage (https://open.kattis.com/problems/ignore)
Execution time: 0.14 s
Submitted on 2017-08-21 11:21:24
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static HashMap<String,String> nums;
    static String[] arr;
    public static String transform(int n)
    {
        StringBuilder sb=new StringBuilder("");
        while(n>0)
        {
            int x=n%7;
            sb.append(nums.get(arr[x]));
            n/=7;
        }
        return sb.toString();
    }
    public static void main(String[] args) {
       Scanner sc = new Scanner(System.in);
       nums=new HashMap<String,String>();
       nums.put("0", "0");
       nums.put("1", "1");
       nums.put("2", "2");
       nums.put("5", "5");
       nums.put("6", "9");
       nums.put("8", "8");
       nums.put("9", "6");
        arr=new String[7];
        arr[0]="0";
        arr[1]="1";
        arr[2]="2";
        arr[3]="5";
        arr[4]="6";
        arr[5]="8";
        arr[6]="9";
        while(sc.hasNext())
            System.out.println(transform(sc.nextInt()));
   }
}
