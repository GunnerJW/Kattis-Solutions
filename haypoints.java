/*
Java solution for the problem Hay Points (https://open.kattis.com/problems/haypoints)
Execution time: 0.53 s
Submitted on 2017-03-12 16:11:02
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),t=sc.nextInt(),i=0;
        Hashtable<String,Integer> ht=new Hashtable<String,Integer>(10000);
        for(i=0;i<n;i++)
        {
            ht.put(sc.next(),sc.nextInt());
        }
        String s="";
        int sum=0;
        for(i=0;i<t;i++)
        {
            s=sc.next();
            while(!s.equals("."))
            {
                if(ht.containsKey(s))
                    sum+=ht.get(s);
                s=sc.next();
            }
            System.out.println(sum);
            sum=0;
        }
    }
}