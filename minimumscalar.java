/*
Java solution for the problem Minimum Scalar Product (https://open.kattis.com/problems/minimumscalar)
Execution time: 0.23 s
Submitted on 2017-05-15 20:53:26
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(),n=0,i=0,j=0;
        long sum=0;
        for(i=0;i<t;i++)
        {
            n=sc.nextInt();
            ArrayList<Long> v1=new ArrayList<Long>(n);
            ArrayList<Long> v2=new ArrayList<Long>(n);
            for(j=0;j<n;j++)
            {
                v1.add(sc.nextLong());
            }
            for(j=0;j<n;j++)
            {
                v2.add(sc.nextLong());
            }
            Collections.sort(v1);
            Collections.sort(v2);
            for(j=0;j<n;j++)
            {
                sum+=v1.get(j)*v2.get(n-1-j);
            }
            System.out.println("Case #"+(i+1)+": "+sum);
            sum=0;
        }
    }
}