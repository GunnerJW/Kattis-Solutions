/*
Java solution for the problem A Different Problem (https://open.kattis.com/problems/different)
Execution time: 0.08 s
Submitted on 2017-03-14 02:36:59
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long x=0,y=0;
        while(sc.hasNext())
        {
            x=sc.nextLong();
            y=sc.nextLong();
            System.out.println((long)Math.abs(x-y));
        }
    }
}