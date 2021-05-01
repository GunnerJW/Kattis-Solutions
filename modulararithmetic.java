/*
Java solution for the problem Modular Arithmetic (https://open.kattis.com/problems/modulararithmetic)
Execution time: 0.31 s
Submitted on 2017-05-11 23:33:28
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    static class Maths
    {
	private static long x;
	private static long y;
	private static long d;
	
	static long gcd(long a,long b)
	{
		return b==0?a:gcd(b,a%b);
	}
	public static void extendedEuclid(long a,long b)
	{
		d=gcd(a,b);
		if (b == 0)
		{ x = 1; y = 0; d = a; return; }
		extendedEuclid(b,a%b);
		long x1 = y;
		long y1 = x - (a / b) * y;
		x = x1;
		y = y1;
	}
	
	public static long getX()
	{
		return x;
	}
	public static long getY()
	{
		return y;
	}
	
}
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        int t=sc.nextInt();
        while(n!=0 || t!=0)
        {
            for(int i=0;i<t;i++)
            {
                long op1=sc.nextLong();
                String s=sc.next();
                long op2=sc.nextLong();
                if(s.equals("+"))
                    System.out.println((op1+op2)%n);
                else if(s.equals("-"))
                {
                    op2*=-1;
                    while(op2<0)
                        op2+=n;
                    System.out.println((op1+op2)%n);
                }
                else if(s.equals("*"))
                {
                    BigInteger bi=BigInteger.ONE;
                    bi=bi.multiply(new BigInteger(String.valueOf(op1)));
                    bi=bi.multiply(new BigInteger(String.valueOf(op2)));
                    System.out.println(bi.mod(new BigInteger(String.valueOf(n))));
                }
                else
                {
                    if(Maths.gcd(op2,n)!=1)
                        System.out.println("-1");
                    else
                    {
                        Maths.extendedEuclid(op2,n);
                        long x=Maths.getX();
                        if(x>=0 && x<n)
                        {
                            BigInteger bi=BigInteger.ONE;
                            bi=bi.multiply(new BigInteger(String.valueOf(op1)));
                            bi=bi.multiply(new BigInteger(String.valueOf(x)));
                            System.out.println(bi.mod(new BigInteger(String.valueOf(n))));
                        }
                        else if(x<0)
                        {
                            while(x<0)
                                x+=n;
                            BigInteger bi=BigInteger.ONE;
                            bi=bi.multiply(new BigInteger(String.valueOf(op1)));
                            bi=bi.multiply(new BigInteger(String.valueOf(x)));
                            System.out.println(bi.mod(new BigInteger(String.valueOf(n))));
                        }
                        else if(x>=n)
                        {
                            while(x>=n)
                                x-=n;
                            BigInteger bi=BigInteger.ONE;
                            bi=bi.multiply(new BigInteger(String.valueOf(op1)));
                            bi=bi.multiply(new BigInteger(String.valueOf(x)));
                            System.out.println(bi.mod(new BigInteger(String.valueOf(n))));
                        }
                    }
                }
            }
            n=sc.nextLong();
            t=sc.nextInt();
        }
    }
}