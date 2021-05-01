/*
Java solution for the problem Popular Vote (https://open.kattis.com/problems/vote)
Execution time: 0.15 s
Submitted on 2017-02-22 11:41:47
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int n=0,i=0,j=0,sum=0,tmp=0,max=0;
        for(i=0;i<t;i++)
        {
            n=sc.nextInt();
            ArrayList<Integer> al=new ArrayList<Integer>(n);
            for(j=0;j<n;j++)
            {
                tmp=sc.nextInt();
                sum+=tmp;
                al.add(tmp);
            }
            ArrayList<Integer> clone=new ArrayList<Integer>(al);
            Collections.sort(clone);
            max=clone.get(n-1);
            if(max==clone.get(n-2))
            {
                System.out.println("no winner");
            }
            else
            {
                if(2*max>sum)
                    System.out.println("majority winner "+(al.indexOf(max)+1));
                else
                    System.out.println("minority winner "+(al.indexOf(max)+1));
            }
            sum=0;
        }
    }
}