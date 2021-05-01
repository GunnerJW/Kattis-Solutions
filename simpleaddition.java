/*
Java solution for the problem Simple Addition (https://open.kattis.com/problems/simpleaddition)
Execution time: 0.15 s
Submitted on 2017-03-07 20:28:16
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        BigInteger b1=new BigInteger(sc.nextLine()),b2=new BigInteger(sc.nextLine());
        System.out.println(b1.add(b2));
    }
}