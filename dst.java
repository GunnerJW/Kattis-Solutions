/*
Java solution for the problem Daylight Saving Time (https://open.kattis.com/problems/dst)
Execution time: 0.13 s
Submitted on 2017-03-08 23:32:53
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),i=0;
        String s="";
        int c=0,h=0,m=0,total=0,nh=0,nm=0;
        for(i=0;i<n;i++)
        {
            s=sc.next();
            c=sc.nextInt();
            h=sc.nextInt();
            m=sc.nextInt();
            total=h*60+m+(s.equals("F")?c:-1*c);
            if(total<0)
                total+=24*60;
            nh=(total/60)%24;
            nm=total-((total/60)*60);
            System.out.println(nh+" "+nm);
        }
    }
}
