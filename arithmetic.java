/*
Java solution for the problem Arithmetic (https://open.kattis.com/problems/arithmetic)
Execution time: 0.99 s
Submitted on 2018-04-30 03:01:12
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;
import java.math.BigInteger;

public class Solution {
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        BigInteger x=new BigInteger(sc.nextLine(),8);
        System.out.println(x.toString(16).toUpperCase());
    }
}