/*
Java solution for the problem Heliocentric (https://open.kattis.com/problems/heliocentric)
Execution time: 0.07 s
Submitted on 2017-08-29 19:22:19
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    //static ArrayList<Integer> 
    public static long[] egcd(long a,long b)
    {
        long x=0,y=1,u=1,v=0;
        while(a!=0)
        {
            long q=b/a,r=b%a;
            long m=x-u*q,n=y-v*q;
            b=a;
            a=r;
            x=u;
            y=v;
            u=m;
            v=n;
        }
        return new long[]{b,x,y};
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int i=1;
        while(sc.hasNext())
        {
            long earth=sc.nextLong();
            long n=365;
            long mars=sc.nextLong();
            long m=687;
            if(earth>0)
                earth=365-earth;
            if(mars>0)
                mars=687-mars;
            long product=m*n;
            long u=egcd(n,m)[1];
            //long v=egcd(n,m)[2];
            long x=earth+(mars-earth)*u*n;
            System.out.print("Case "+i+": ");
            if(x>=0 && x<product)
                System.out.println(x);
            else if(x<0)
            {
                long k=(long)Math.ceil(-1.0*x/product);
                System.out.println(x+k*product);
            }
            else
                System.out.println(x%product);
            i++;
        }
    }
}

