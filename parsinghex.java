/*
Java solution for the problem Parsing Hex (https://open.kattis.com/problems/parsinghex)
Execution time: 0.12 s
Submitted on 2017-03-20 02:08:04
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.regex.*;
import java.util.Scanner;
import java.lang.Math;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s="";
        Pattern p=Pattern.compile("0[xX][0-9a-fA-F]{1,8}");
        while(sc.hasNext())
        {
            s=sc.nextLine();
            Matcher m = p.matcher(s);
            while(m.find())
                System.out.println(m.group(0)+" "+Long.parseLong(m.group(0).substring(2),16));
            //System.out.println(s.matches());
        }
    }
}