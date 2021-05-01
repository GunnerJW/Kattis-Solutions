/*
Java solution for the problem Different Distances (https://open.kattis.com/problems/differentdistances)
Execution time: 0.32 s
Submitted on 2017-02-22 09:18:06
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        double x1=0,y1=0,x2=0,y2=0;
        double p=0;
        double a=0,b=0;
        while(true)
        {
            try
            {
                x1=sc.nextDouble();
                y1=sc.nextDouble();
                x2=sc.nextDouble();
                y2=sc.nextDouble();
                p=sc.nextDouble();
                a=Math.pow(Math.abs(x1-x2),p);
                b=Math.pow(Math.abs(y1-y2),p);
                System.out.println(Math.pow(a+b,1/p));
            }
            catch(NoSuchElementException e)
            {
                break;
            }
        }
    }
}