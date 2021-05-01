/*
Java solution for the problem Bus (https://open.kattis.com/problems/bus)
Execution time: 0.07 s
Submitted on 2017-02-22 10:00:19
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        int k=0;
        for(int i=0;i<t;i++)
        {
            k=sc.nextInt();
            System.out.println((int)Math.pow(2,k)-1);
        }
    }
}