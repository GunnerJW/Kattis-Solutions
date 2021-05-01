/*
Java solution for the problem Sierpiński Circumference (https://open.kattis.com/problems/triangle)
Execution time: 0.09 s
Submitted on 2017-03-21 14:40:05
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=0,i=1,d=0;
        while(sc.hasNext())
        {
            n=sc.nextInt();
            d=(int)(Math.log10(3)+n*Math.log10(1.5))+1;
            System.out.println("Case "+i+": "+d);
            i++;
        }
    }
}
