/*
Java solution for the problem Oktalni (https://open.kattis.com/problems/oktalni)
Execution time: 0.07 s
Submitted on 2017-03-18 15:29:17
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s=sc.nextLine();
        if(s.length()%3==1)
        {
            String pad="00";
            s=pad.concat(s);
        }
        else if(s.length()%3==2)
        {
            String pad="0";
            s=pad.concat(s);
        }
        String oct="";
        int i=0;
        while(i!=s.length()-3)
        {
            oct=oct.concat(String.valueOf(Integer.parseInt(s.substring(i,i+3),2)));
            i+=3;
        }
        oct=oct.concat(String.valueOf(Integer.parseInt(s.substring(i),2)));
        System.out.println(oct);
      }
}