/*
Java solution for the problem Soda Slurper (https://open.kattis.com/problems/sodaslurper)
Execution time: 0.07 s
Submitted on 2017-04-12 00:15:43
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int e=sc.nextInt(),f=sc.nextInt(),c=sc.nextInt();
        int empty=e+f;
        int drank=0;
        while(empty>=c)
        {
            drank+=empty/c;
            empty=(empty/c)+(empty%c);
        }
        System.out.println(drank);
    }
}