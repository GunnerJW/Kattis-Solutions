/*
Java solution for the problem Candy Division (https://open.kattis.com/problems/candydivision)
Execution time: 0.1 s
Submitted on 2017-08-29 17:12:36
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long N=sc.nextLong();
        TreeSet<Long> factors=new TreeSet<Long>();
        for(int i=1;i<=(int)Math.sqrt(N);i++)
        {
            if(N%i==0)
            {
                factors.add((long)i-1);
                factors.add(N/i-1);
            }
        }
        for(long f : factors)
            System.out.print(f+" ");
    }
}