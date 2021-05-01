/*
Java solution for the problem Goldbach's Conjecture (https://open.kattis.com/problems/goldbach2)
Execution time: 0.36 s
Submitted on 2017-03-19 00:00:35
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static boolean isPrime(int n)
    {
        for(int i=2;i<=(int)Math.sqrt(n);i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt(),i=0;
        int x=0,j=0,r=0;
        for(i=0;i<t;i++)
        {
            x=sc.nextInt();
            ArrayList<String> al=new ArrayList<String>();
            for(j=2;j<=x/2;j++)
            {
                if(isPrime(j) && isPrime(x-j))
                {
                    r++;
                    al.add(j+"+"+(x-j));
                }
            }
            System.out.println(x+" has "+r+" representation(s)");
            for(String test : al)
                System.out.println(test);
            System.out.println("");
            r=0;
        }
    }
}
