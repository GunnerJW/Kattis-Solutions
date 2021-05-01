/*
Java solution for the problem Bits (https://open.kattis.com/problems/bits)
Execution time: 0.13 s
Submitted on 2017-03-15 21:33:30
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
        int n=sc.nextInt(),i=0,max=0,curr=0,j=0;
        String s="";
        for(i=0;i<n;i++)
        {
            s=sc.next();
            for(j=1;j<=s.length()-1;j++)
            {
                curr=Integer.bitCount(Integer.parseInt(s.substring(0,j)));
                max=(curr>max)?curr:max;
            }
            curr=Integer.bitCount(Integer.parseInt(s));
            max=(curr>max)?curr:max;
            System.out.println(max);
            max=0;
        }
    }
}
