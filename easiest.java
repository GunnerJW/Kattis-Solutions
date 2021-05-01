/*
Java solution for the problem The Easiest Problem Is This One (https://open.kattis.com/problems/easiest)
Execution time: 0.14 s
Submitted on 2017-05-04 19:34:15
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        long x;
        while(n!=0)
        {
            long tmp=n;
            int sumdn=0;
            while(tmp!=0)
            {
                sumdn+=tmp%10;
                tmp/=10;
            }
            int p=11;
            while(true)
            {
                int sumdp=0;
                x=p*n;
                long tmp2=x;
                while(tmp2!=0)
                {
                    sumdp+=tmp2%10;
                    tmp2/=10;
                }
                if(sumdp==sumdn)
                {
                    System.out.println(p);
                    break;
                }
                p++;
            }
            n=sc.nextLong();
        }
    }
}
