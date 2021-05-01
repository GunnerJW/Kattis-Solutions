/*
Java solution for the problem Compound Words (https://open.kattis.com/problems/compoundwords)
Execution time: 0.07 s
Submitted on 2017-03-07 13:48:33
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        String s="";
        while(sc.hasNext())
        {
            s=s.concat(sc.nextLine());
            s=s.concat(" ");
        }
        String[] arr=s.split(" ");
        TreeSet<String> ts=new TreeSet<String>();
        for(int i=0;i<arr.length-1;i++)
        {
            for(int j=i+1;j<arr.length;j++)
            {
                s="";
                s=s.concat(arr[i]);
                s=s.concat(arr[j]);
                ts.add(s);
                s="";
                s=s.concat(arr[j]);
                s=s.concat(arr[i]);
                ts.add(s);
            }    
        }
        for(String x:ts)
            System.out.println(x);
    }
}