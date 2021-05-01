/*
Java solution for the problem Support Vector Machine (https://open.kattis.com/problems/svm)
Execution time: 2.66 s
Submitted on 2017-03-18 15:10:31
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),i=0;
        double[] w=new double[n];
        double b=0,lw=0,product=0;
        for(i=0;i<n;i++)
        {
            w[i]=sc.nextDouble();
            lw+=w[i]*w[i];
        }
        lw=Math.sqrt(lw);
        b=sc.nextDouble();
        while(sc.hasNext())
        {
            for(i=0;i<n;i++)
            {
                product+=w[i]*sc.nextDouble();
            }
            System.out.println((product+b)/lw);
            product=0;
        }
      }
}