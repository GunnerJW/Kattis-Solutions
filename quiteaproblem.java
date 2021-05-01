/*
Java solution for the problem Quite a Problem (https://open.kattis.com/problems/quiteaproblem)
Execution time: 0.19 s
Submitted on 2017-03-08 20:14:08
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s="";
        while(sc.hasNext())
        {
            s=sc.nextLine();
            if(s.matches("^(.*)([Pp][Rr][Oo][Bb][Ll][Ee][Mm])(.*)$"))
                System.out.println("yes");
            else
                System.out.println("no");
        }
    }
}
