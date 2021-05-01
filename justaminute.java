/*
Java solution for the problem Just a Minute (https://open.kattis.com/problems/justaminute)
Execution time: 0.18 s
Submitted on 2017-02-25 21:02:43
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i=0;
        double a=0,b=0;
        double x=0;
        for(i=0;i<n;i++)
        {
            a+=sc.nextDouble();
            b+=sc.nextDouble();
        }
        x=b/(a*60);
        //System.out.println(x);
        if(x<=1)
            System.out.println("measurement error");
        else
            System.out.println(x);
    }
}