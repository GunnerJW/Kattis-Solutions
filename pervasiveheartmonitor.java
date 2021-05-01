/*
Java solution for the problem Pervasive Heart Monitor (https://open.kattis.com/problems/pervasiveheartmonitor)
Execution time: 0.1 s
Submitted on 2017-02-27 23:16:06
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        String s="",name="";
        int i=0;
        char c='x';
        int a=0,z=0,A=0,Z=0;
        double sum=0,av=0,num=0;
        while(sc.hasNext())
        {
            s=sc.nextLine();
            String arr[]=s.split(" ");
            for(i=0;i<arr.length;i++)
            {
                //System.out.println(arr[i].charAt(0));
                c=arr[i].charAt(0);
                a=Character.compare(c,'a');
                z=Character.compare(c,'z');
                A=Character.compare(c,'A');
                Z=Character.compare(c,'Z');
                if((a>=0 && z<=0) || (A>=0 && Z<=0))
                    name=name.concat(arr[i]+" ");
                else
                {
                    sum+=Double.parseDouble(arr[i]);
                    num++;
                }    
            }
            av=sum/num;
            name.trim();
            System.out.println(av+" "+name);
            name="";
            sum=0;
            num=0;
        }
    }
}