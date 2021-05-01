/*
Java solution for the problem Paul Eigon (https://open.kattis.com/problems/pauleigon)
Execution time: 0.07 s
Submitted on 2017-03-05 14:17:46
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),p=sc.nextInt(),q=sc.nextInt();
        if(((p+q)/n)%2==0)
            System.out.println("paul");
        else
            System.out.println("opponent");
    }
}
