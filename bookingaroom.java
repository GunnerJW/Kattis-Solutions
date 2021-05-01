/*
Java solution for the problem Booking a Room (https://open.kattis.com/problems/bookingaroom)
Execution time: 0.08 s
Submitted on 2017-03-01 20:47:43
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int r=sc.nextInt();
        int n=sc.nextInt();
        int i=0;
        if(n==r)
            System.out.println("too late");
        else
        {
            TreeSet<Integer> ts=new TreeSet<Integer>();
            for(i=0;i<n;i++)
            {
                ts.add(sc.nextInt());
            }
            lp:for(i=1;i<=r;i++)
            {
                if(!ts.contains(i))
                {
                    System.out.println(i);
                    break lp;
                }
            }
        }
    }
}
