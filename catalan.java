/*
Java solution for the problem Catalan Numbers (https://open.kattis.com/problems/catalan)
Execution time: 0.51 s
Submitted on 2017-04-11 15:04:22
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

     public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        ArrayList<BigInteger> al=new ArrayList<BigInteger>(5001);
        al.add(new BigInteger("1"));
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt();
            if(x<al.size())
                System.out.println(al.get(x));
            else
            {
                int j;
                for(j=al.size();j<=x;j++)
                {
                    BigInteger bi=new BigInteger("1");
                    bi=bi.multiply(al.get(j-1));
                    int f=2*(2*j-1);
                    bi=bi.multiply(new BigInteger(String.valueOf(f)));
                    f=j+1;
                    bi=bi.divide(new BigInteger(String.valueOf(f)));
                    al.add(bi);
                }
                System.out.println(al.get(x));
            }
            //System.out.println(x);
        }
    }
}