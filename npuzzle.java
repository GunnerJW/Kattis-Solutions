/*
Java solution for the problem N-Puzzle (https://open.kattis.com/problems/npuzzle)
Execution time: 0.07 s
Submitted on 2017-03-15 13:28:44
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        ArrayList<String> al=new ArrayList<String>(Arrays.asList("A","B","C","D","E","F","G","H","I","J","K","L","M","N","O"));
        //System.out.println(al);
        int i=0,pos=0,curr_row=0,curr_col=0,scatter=0,supp_row=0,supp_col=0;
        String s="",c="";
        while(sc.hasNext())
        {
            s=sc.next();
            for(i=0;i<4;i++)
            {
                c=String.valueOf(s.charAt(i));
                if(!c.equals("."))
                {
                    curr_row=pos/4;
                    curr_col=pos%4;
                    supp_row=al.indexOf(c)/4;
                    supp_col=al.indexOf(c)%4;
                    scatter+=(int)Math.abs(supp_row-curr_row)+(int)Math.abs(supp_col-curr_col);
                    //System.out.print(scatter);
                }
                pos++;
            }
        }
        System.out.print(scatter);
    }
}