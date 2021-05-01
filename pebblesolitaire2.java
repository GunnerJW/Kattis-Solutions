/*
Java solution for the problem Pebble Solitaire (https://open.kattis.com/problems/pebblesolitaire2)
Execution time: 0.12 s
Submitted on 2018-05-05 16:15:32
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static String pad(String s)
    {
        StringBuilder res=new StringBuilder(s);
        while(res.length()<23)
            res.insert(0,'0');
        return res.toString();
    }
    static int length(int id)
    {
        int res=0;
        int tmp=id;
        while(tmp>0)
        {
            res+=tmp%2;
            tmp=tmp>>1;
        }
        return res;
    }
    static int compute(int id)
    {
        //System.out.println(pad(Integer.toBinaryString(id)));
        if(memo[id]!=-1)
            return memo[id];
        int res=length(id);
        for(int i=22;i>=0;i--)
        {
            int tmp=(1<<i)|(1<<(i+1));
            if((id&tmp)==tmp)
            {
                if(i>=1 && (id&(1<<(i-1)))==0)
                {
                    int new_id=id&(~(1<<(i+1)));
                    new_id=new_id|(1<<(i-1));
                    new_id=new_id&(~(1<<i));
                    res=Math.min(res,compute(new_id));
                }
                if(i<21 && (id&(1<<(i+2)))==0)
                {
                    int new_id=id&(~(1<<i));
                    new_id=new_id|(1<<(i+2));
                    new_id=new_id&(~(1<<(i+1)));
                    res=Math.min(res,compute(new_id));
                }
            }
        }
        return memo[id]=res;
    }
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        memo=new int[(1<<23)];
        Arrays.fill(memo,-1);
        int n=sc.nextInt();
        for(int i=0;i<n;i++)
        {
            String s=sc.next();
            int x=0;
            for(int j=0;j<23;j++)
            {
                //System.out.print(s.charAt(j));
                if(s.charAt(j)=='o')
                    x|=(1<<(22-j));
            }
            System.out.println(compute(x));
        }     
    }
}
