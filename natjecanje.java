/*
Java solution for the problem Natjecanje (https://open.kattis.com/problems/natjecanje)
Execution time: 0.07 s
Submitted on 2017-05-07 20:36:19
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),k=sc.nextInt(),r=sc.nextInt();
        boolean[] hasMain=new boolean[n+1];
        boolean[] hasReserve=new boolean[n+1];
        for(int i=0;i<=n;i++)
            hasMain[i]=true;
        for(int i=0;i<k;i++)
            hasMain[sc.nextInt()]=false;
        for(int i=0;i<r;i++)
            hasReserve[sc.nextInt()]=true;
        int cannotStart=0;
        //System.out.println(Arrays.toString(hasMain));
        lp:for(int i=1;i<n;i++)
        {
            if(!hasMain[i])
            {
                if(hasReserve[i])
                {
                    hasReserve[i]=false;
                    continue lp;
                }
                if(hasReserve[i-1])
                {
                    hasReserve[i-1]=false;
                    continue lp;
                }
                if(hasReserve[i+1])
                {
                    hasReserve[i+1]=false;
                    continue lp;
                }
                cannotStart++;
            }
        }
        if(!hasMain[n] && !hasReserve[n] && !hasReserve[n-1])
            cannotStart++;
        System.out.println(cannotStart);
    }
}