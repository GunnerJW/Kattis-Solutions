/*
Java solution for the problem Circular Lock (https://open.kattis.com/problems/circularlock)
Execution time: 0.1 s
Submitted on 2017-08-26 17:32:17
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    public static int gcd(int a,int b)
	{
		return b==0?a:gcd(b,a%b);
	}
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            //int[][] s=new int[2][2];
            //int[][] p=new int[2][2];
            int s11=sc.nextInt();
            int s12=sc.nextInt();
            int p11=sc.nextInt();
            int p12=sc.nextInt();
            int s21=sc.nextInt();
            int s22=sc.nextInt();
            int p21=sc.nextInt();
            int p22=sc.nextInt();
            int p=gcd(p11,p12);
            p=gcd(p,p21);
            p=gcd(p,p22);
            s11=s11%p;
            s12=s12%p;
            s21=s21%p;
            s22=s22%p;
            if((s12+s21)%p==(s22+s11)%p)
                System.out.println("Yes");
            else
                System.out.println("No");
        }
    }
}
