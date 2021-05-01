/*
Java solution for the problem Crne (https://open.kattis.com/problems/crne)
Execution time: 0.07 s
Submitted on 2017-03-26 02:32:20
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        long n=sc.nextLong();
        if(n%2==0)
            System.out.println((n/2+1)*(n/2+1));
        else
            System.out.println((n+3)*(n+1)/4);
      }
}