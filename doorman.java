/*
Java solution for the problem Doorman (https://open.kattis.com/problems/doorman)
Execution time: 0.07 s
Submitted on 2017-05-04 21:31:00
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int maxdiff=sc.nextInt();
        sc.nextLine();
        String s=sc.nextLine();
        StringBuilder sb=new StringBuilder(s);
        int in=0;
        int diff;
        int m=0,w=0;
        boolean broken=false;
        lp:while(sb.length()!=0)
        {
            char c=sb.charAt(0);
            if(Character.compare(c,'M')==0)
            {
                if((int)Math.abs(m+1-w)>maxdiff)
                {
                    if(Character.compare(sb.charAt(1),'M')==0)
                    {
                        System.out.println(in);
                        broken=true;
                        break lp;
                    }
                    else
                    {
                        w++;
                        in++;
                        diff=(int)Math.abs(m-w);
                        sb.deleteCharAt(1);
                    }
                }
                else
                {
                    m++;
                    in++;
                    diff=(int)Math.abs(m-w);
                    sb.deleteCharAt(0);
                }
            }
            else
            {
                if((int)Math.abs(w+1-m)>maxdiff)
                {
                    if(Character.compare(sb.charAt(1),'W')==0)
                    {
                        System.out.println(in);
                        broken=true;
                        break lp;
                    }
                    else
                    {
                        m++;
                        in++;
                        diff=(int)Math.abs(m-w);
                        sb.deleteCharAt(1);
                    }
                }
                else
                {
                    w++;
                    in++;
                    diff=(int)Math.abs(m-w);
                    sb.deleteCharAt(0);
                }
            }
        }
        if(broken==false)
            System.out.println(in);
    }
}
