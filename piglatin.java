/*
Java solution for the problem Pig Latin (https://open.kattis.com/problems/piglatin)
Execution time: 1.87 s
Submitted on 2017-03-14 14:40:22
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        String s="",aux="";
        int i=0,j=0;
        String vowels="aeiouy";
        while(sc.hasNext())
        {
            s=sc.nextLine();
            String[] arr=s.split(" ");
            for(i=0;i<arr.length;i++)
            {
                if(vowels.contains(String.valueOf(arr[i].charAt(0))))
                {
                    System.out.print(arr[i]);
                    System.out.print("yay ");                    
                }
                else
                {
                    while(!vowels.contains(String.valueOf(arr[i].charAt(j))))
                    {
                        j++;
                    }
                    System.out.print(arr[i].substring(j));
                    System.out.print(arr[i].substring(0,j));
                    System.out.print("ay ");
                    j=0;
                }
            }
            System.out.println("");
        }
    }
}
