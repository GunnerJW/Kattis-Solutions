/*
Java solution for the problem Reseto (https://open.kattis.com/problems/reseto)
Execution time: 0.17 s
Submitted on 2017-03-25 16:08:25
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt();
        boolean[] sieve=new boolean[n+1];
        sieve[0]=true;
        sieve[1]=true;
        int i,j,crossed=0;
        lp:while(true)
        {
            for(i=0;i<sieve.length;i++)
            {
                if(!sieve[i])
                    break;
            }
            for(j=i;j<sieve.length;j+=i)
            {
                if(!sieve[j])
                {
                    crossed++;
                    if(crossed==k)
                    {
                        System.out.println(j);
                        break lp;
                    }
                    sieve[j]=true;
                }
            }
        }
        //System.out.println(Arrays.toString(sieve));
    }
}