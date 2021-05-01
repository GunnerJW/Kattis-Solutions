/*
Java solution for the problem Dyslectionary (https://open.kattis.com/problems/dyslectionary)
Execution time: 0.14 s
Submitted on 2017-05-15 19:27:04
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String> al=new ArrayList<String>(100);
        int max=0;
        while(sc.hasNext())
        {
            StringBuilder sb=new StringBuilder(sc.nextLine());
            if(sb.length()==0)
            {
                Collections.sort(al);
                for(String x : al)
                {
                    for(int i=0;i<max-x.length();i++)
                        System.out.print(" ");
                    System.out.println((new StringBuilder(x)).reverse());
                }
                System.out.println();
                al.clear();
                max=0;
            }
            else
            {
                al.add(sb.reverse().toString());
                max=Math.max(max,sb.length());
            }
        }
        Collections.sort(al);
        for(String x : al)
        {
            for(int i=0;i<max-x.length();i++)
                System.out.print(" ");
            System.out.println((new StringBuilder(x)).reverse());
        }
    }
}
