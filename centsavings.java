/*
Java solution for the problem Cent Savings (https://open.kattis.com/problems/centsavings)
Execution time: 1.68 s
Submitted on 2017-08-14 14:54:41
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

public class Solution{
    static int[] items;
    static int[] sums;
    static int n;
    static int d;
    static int[][][] memo;
    static int round(int x)
    {
        int w=x%10;
        if(w<5)
            return x-w;
        return x+(10-w);
    }
    static int arrange(int index,int dividers,int last)
    {
        if(index==n+1 || dividers ==0)
            return round(sums[n]-sums[last]);
        if(memo[index][dividers][last]!=-1)
            return memo[index][dividers][last];
        return memo[index][dividers][last]=Math.min(round(sums[index]-sums[last])+arrange(index+1,dividers-1,index),arrange(index+1,dividers,last));
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        d=sc.nextInt();
        items=new int[n+1];
        sums=new int[n+1];
        for(int i=1;i<=n;i++)
        {
            items[i]=sc.nextInt();
            sums[i]=items[i]+sums[i-1];
        }
        //System.out.println(Arrays.toString(sums));
        memo=new int[n+1][d+1][n+1];
        for(int[][] x : memo)
            for(int[] y : x)
                Arrays.fill(y,-1);
        System.out.println(arrange(0,d,0));
        //System.out.println(Arrays.deepToString(memo));
    }
}