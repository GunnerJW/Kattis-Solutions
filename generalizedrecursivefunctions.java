/*
Java solution for the problem Generalized Recursive Functions (https://open.kattis.com/problems/generalizedrecursivefunctions)
Execution time: 0.68 s
Submitted on 2017-08-30 23:52:18
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;
public class Solution {
    static BigInteger minusOne=new BigInteger("-1");
    static int n;
    static int p;
    static int[] a;
    static int[] b;
    static String c;
    static BigInteger d;
    static BigInteger[][] memo;
    static BigInteger f(int x,int y)
    {
        if(x==0 && y==0)
            return memo[0][0]=d;
        if(x<=0 || y<=0)
            return d;
        if(!memo[x][y].equals(minusOne))
            return memo[x][y];
        BigInteger sum=new BigInteger(c);
        for(int i=0;i<(n-2)/2;i++)
            sum=sum.add(f(x-a[i],y-b[i]));
        return memo[x][y]=sum;
    }
    public static void main(String args[] ) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<t;i++)
        {
            String[] arr=sc.nextLine().split(" ");
            n=arr.length;
            a=new int[(n-2)/2];
            b=new int[(n-2)/2];
            for(int j=0;j<n-2;j+=2)
            {
                a[j/2]=Integer.parseInt(arr[j]);
                b[j/2]=Integer.parseInt(arr[j+1]);
            }
            c=arr[n-2];
            d=new BigInteger(arr[n-1]);
            arr=sc.nextLine().split(" ");
            p=arr.length;
            memo=new BigInteger[100][100];
            for(BigInteger[] tmp : memo)
                Arrays.fill(tmp,minusOne);
            for(int j=0;j<p;j+=2)
            {
                int x=Integer.parseInt(arr[j]);
                int y=Integer.parseInt(arr[j+1]);
                System.out.println(f(x,y));
            }
            System.out.println("");
        }
    }
}
