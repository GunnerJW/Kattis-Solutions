/*
Java solution for the problem Incognito (https://open.kattis.com/problems/incognito)
Execution time: 0.1 s
Submitted on 2017-03-20 22:09:14
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt(),i=0,n=0,j=0;
        String s="";
        int c=1;
        for(i=0;i<t;i++)
        {
            Hashtable<String,Integer> ht=new Hashtable<String,Integer>();
            n=sc.nextInt();
            for(j=0;j<n;j++)
            {
                sc.next();
                s=sc.next();
                if(ht.containsKey(s))
                    ht.put(s,ht.get(s)+1);
                else
                    ht.put(s,1);
            }
            HashSet<String> hs=new HashSet<String>(ht.keySet());
            for(String x : hs)
                c*=ht.get(x)+1;
            System.out.println(c-1);
            c=1;
        }
    }
}
