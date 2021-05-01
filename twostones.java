/*
Java solution for the problem Take Two Stones (https://open.kattis.com/problems/twostones)
Execution time: 0.07 s
Submitted on 2017-09-30 20:37:14
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        if(n%2==1)
            System.out.print("Alice");
        else    
            System.out.print("Bob");
    }
}
