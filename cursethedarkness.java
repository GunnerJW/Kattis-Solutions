/*
Java solution for the problem Curse the Darkness (https://open.kattis.com/problems/cursethedarkness)
Execution time: 0.69 s
Submitted on 2017-03-17 23:58:53
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(),i=0;
        double x=0,y=0,xb=0,yb=0;
        int n=0,j=0;
        boolean light=false;
        for(i=0;i<t;i++)
        {
            x=sc.nextDouble();
            y=sc.nextDouble();
            n=sc.nextInt();
            for(j=0;j<n;j++)
            {
                xb=sc.nextDouble();
                yb=sc.nextDouble();
                if(Math.sqrt((x-xb)*(x-xb)+(y-yb)*(y-yb))<=8)
                    light=true;
            }
            if(light==true)
                System.out.println("light a candle");
            else
                System.out.println("curse the darkness");
            light=false;
        }
    }
}