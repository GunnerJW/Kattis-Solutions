/*
Java solution for the problem Jabuke (https://open.kattis.com/problems/jabuke)
Execution time: 0.1 s
Submitted on 2017-03-12 21:10:09
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        double x1=sc.nextDouble(),y1=sc.nextDouble(),x2=sc.nextDouble(),y2=sc.nextDouble(),x3=sc.nextDouble(),y3=sc.nextDouble();
        double area=0.5*Math.abs(x1*(y2-y3)+x2*(y3-y1)+x3*(y1-y2));
        System.out.println(area);
        int n=sc.nextInt(),i=0;
        double x=0,y=0;
        double t1=0,t2=0;
        int number=0;
        for(i=0;i<n;i++)
        {
            x=sc.nextDouble();
            y=sc.nextDouble();
            t1=(x*(y3-y1)+y*(x1-x3)-x1*y3+y1*x3)/(x1*(y2-y3)+y1*(x3-x2)+x2*y3-y2*x3);
            t2 = (x*(y2 - y1) + y*(x1 - x2) - x1*y2 + y1*x2) / -(x1*(y2 - y3) + y1*(x3 - x2) + x2*y3 - y2*x3);
            //System.out.println(t1+" "+t2);
            if(t1>=0 && t2>=0 && t1<=1 && t2<=1 && t1+t2<=1)
                number++;
        }
        System.out.println(number);
}
}