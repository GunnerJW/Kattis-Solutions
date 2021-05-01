/*
Java solution for the problem Vacuumba (https://open.kattis.com/problems/vacuumba)
Execution time: 0.12 s
Submitted on 2017-03-07 18:27:24
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=0,i=0,j=0;
        double x=0,y=0,d=0,curra=0,a=0;
        for(i=0;i<n;i++)
        {
            m=sc.nextInt();
            a=sc.nextDouble()*Math.PI/180;
            d=sc.nextDouble();
            x=-1*Math.sin(a)*d;
            y=Math.cos(a)*d;
            curra=a;
            for(j=1;j<m;j++)
            {
                a=sc.nextDouble()*Math.PI/180;
                d=sc.nextDouble();
                x-=Math.sin(a+curra)*d;
                y+=Math.cos(a+curra)*d;
                curra+=a;
            }
            System.out.println(x+" "+y);
        }
    }
}