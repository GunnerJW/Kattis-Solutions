/*
Java solution for the problem Buying Coke (https://open.kattis.com/problems/coke)
Execution time: 0.48 s
Submitted on 2018-05-08 01:08:11
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static int compute(int bought,int fives,int tens)
    {
        //System.out.println(bought+" "+fives+" "+tens);
        if(bought==cokes)
            return 0;
        if(memo[bought][fives][tens]!=-1)
            return memo[bought][fives][tens];
        int ones=initial_amount-8*bought-5*fives-10*tens;
        //System.out.println(ones);
        int res=Integer.MAX_VALUE;
        if(tens>=1 && ones>=3)
            res=Math.min(res,4+compute(bought+1,fives+1,tens-1));
        if(tens>=1)
            res=Math.min(res,1+compute(bought+1,fives,tens-1));
        if(fives>=2)
            res=Math.min(res,2+compute(bought+1,fives-2,tens));
        if(fives>=1 && ones>=3)
            res=Math.min(res,4+compute(bought+1,fives-1,tens));
        if(ones>=8)
            res=Math.min(res,8+compute(bought+1,fives,tens));
        return memo[bought][fives][tens]=res;
    }
    static int[][][] memo;
    static int cokes;
    static int c1;
    static int c5;
    static int c10;
    static int initial_amount;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        while(t-->0)
        {
            memo=new int[151][151][51];
            for(int[][] tmp1:memo)
                for(int[] tmp2:tmp1)
                    Arrays.fill(tmp2,-1);
            cokes=sc.nextInt();
            c1=sc.nextInt();
            c5=sc.nextInt();
            c10=sc.nextInt();
            initial_amount=c1+5*c5+10*c10;
            System.out.println(compute(0,c5,c10));
        }
    }
}
