/*
Java solution for the problem Flexible Spaces (https://open.kattis.com/problems/flexible)
Execution time: 0.08 s
Submitted on 2017-05-15 19:27:47
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int w=sc.nextInt(),p=sc.nextInt(),i=0;
        ArrayList<Integer> al=new ArrayList<Integer>(p+2);
        al.add(0);
        for(i=0;i<p;i++)
        {
            al.add(sc.nextInt());
        }
        al.add(w);
        lp:for(i=1;i<=w;i++)
        {
            for(int x:al)
            {
                if(al.contains(i+x))
                {
                    System.out.print(i+" ");
                    continue lp;
                }
            }
        }
      }
}
