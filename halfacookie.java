/*
Java solution for the problem Half a Cookie (https://open.kattis.com/problems/halfacookie)
Execution time: 0.17 s
Submitted on 2017-03-06 21:04:06
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double r=0,x=0,y=0,d=0,c=0,a=0,ar1=0,ar2=0;
        while(sc.hasNext())
        {
            r=sc.nextDouble();
            x=sc.nextDouble();
            y=sc.nextDouble();
            d=Math.sqrt(x*x+y*y);
            if(d>=r)
                System.out.println("miss");
            else
            {
                c=Math.sqrt(r*r-d*d);
                a=2*Math.asin(c/r);
                ar1=r*r*a/2-d*c;
                ar2=r*r*Math.PI-ar1;
                System.out.println(ar2+" "+ar1);
            }
        }
    }
}