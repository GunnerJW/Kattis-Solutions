/*
Java solution for the problem Darts (https://open.kattis.com/problems/dartscores)
Execution time: 1.51 s
Submitted on 2017-03-12 03:38:10
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(),i=0,j=0,n=0,x=0,y=0,sum=0;
        double d=0;
        for(i=0;i<t;i++)
        {
            n=sc.nextInt();
            for(j=0;j<n;j++)
            {
                x=sc.nextInt();
                y=sc.nextInt();
                d=Math.sqrt(x*x+y*y);
                if(d<=200)
                {
                    if(d==0)
                        sum+=10;
                    else
                    {
                        sum+=11-(int)Math.ceil(d/20);
                    }
                }
            }
            System.out.println(sum);
            sum=0;
        }
    }
}
