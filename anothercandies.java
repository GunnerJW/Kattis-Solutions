/*
Java solution for the problem Another Candies (https://open.kattis.com/problems/anothercandies)
Execution time: 0.29 s
Submitted on 2017-03-17 14:10:09
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        BigInteger bi=new BigInteger("0");
        int t=sc.nextInt(),i=0,children=0,j=0;
        sc.nextLine();
        for(i=0;i<t;i++)
        {
            sc.nextLine();
            children=sc.nextInt();
            sc.nextLine();
            for(j=0;j<children;j++)
            {
                bi=bi.add(new BigInteger(sc.nextLine()));
            }
            if(bi.mod(new BigInteger(String.valueOf(children))).intValue()==0)
                System.out.println("YES");
            else
                System.out.println("NO");
            bi=new BigInteger("0");
        }
    }
}