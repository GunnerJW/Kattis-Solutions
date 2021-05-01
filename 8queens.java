/*
Java solution for the problem Eight Queens (https://open.kattis.com/problems/8queens)
Execution time: 0.07 s
Submitted on 2018-04-30 02:53:35
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) throws IOException{
        Scanner sc=new Scanner(System.in);
        ArrayList<Integer> queens=new ArrayList<Integer>(8);
        for(int i=0;i<8;i++)
        {
            String s=sc.nextLine();
            for(int j=0;j<8;j++)
                if(s.charAt(j)=='*')
                    queens.add(8*i+j);
        }
        //System.out.println(queens);
        if(queens.size()!=8)
            System.out.println("invalid");
        else
        {
            boolean valid=true;
            lp:for(int i=0;i<queens.size()-1;i++)
                for(int j=i+1;j<queens.size();j++)
                {
                    int a=queens.get(i);
                    int b=queens.get(j);
                    if(a/8==b/8 || a%8==b%8 || b/8-a/8==(int)Math.abs(b%8-a%8))
                    {
                        //System.out.println(i+" and "+j);
                        valid=false;
                        break lp;
                    }
                }
            if(valid)
                System.out.println("valid");
            else
                System.out.println("invalid");                
        }   
    }
}