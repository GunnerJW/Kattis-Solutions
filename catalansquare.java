/*
Java solution for the problem Catalan Square (https://open.kattis.com/problems/catalansquare)
Execution time: 0.55 s
Submitted on 2017-04-14 06:14:22
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        sc.close();
        BigInteger[] cat=new BigInteger[n+1];
        cat[0]=BigInteger.ONE;
        for(int i=1;i<=n;i++)
        {
            BigInteger bi=new BigInteger("1");
            bi=bi.multiply(cat[i-1]);
            bi=bi.multiply(new BigInteger(String.valueOf(2*(2*i-1))));
            bi=bi.divide(new BigInteger(String.valueOf(i+1)));
            cat[i]=bi;
            //System.out.println(cat[i]);
        }
        BigInteger bi=BigInteger.ZERO;
        //System.out.println(bi);
        for(int i=0;i<=n;i++)
        {
            bi=bi.add(cat[i].multiply(cat[n-i]));
        }
        System.out.println(bi);
    }
}