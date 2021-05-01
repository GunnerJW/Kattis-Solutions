/*
Java solution for the problem Dejavu (https://open.kattis.com/problems/dejavu)
Execution time: 0.73 s
Submitted on 2018-05-01 00:36:20
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;


public class Solution {
    
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        HashMap<Integer,HashSet> x=new HashMap<Integer,HashSet>();
        HashMap<Integer,HashSet> y=new HashMap<Integer,HashSet>();
        for(int i=0;i<n;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            if(x.containsKey(a))
                x.get(a).add(b);
            else
            {
                x.put(a,new HashSet<Integer>());
                x.get(a).add(b);
            }
            if(y.containsKey(b))
                y.get(b).add(a);
            else
            {
                y.put(b,new HashSet<Integer>());
                y.get(b).add(a);
            }
        }
        long total=0;
        HashSet<Integer> hsx=new HashSet<Integer>(x.keySet());
        for(int tmp:hsx)
        {
            HashSet<Integer> aux=new HashSet<Integer>(x.get(tmp));
            for(int tmp2:aux)
                total+=((long)(y.get(tmp2).size()-1))*(x.get(tmp).size()-1);
            // System.out.println(x.get(tmp).getClass());
        }
        System.out.println(total);
        //System.out.println(x);
        //System.out.println(y);
    }
}