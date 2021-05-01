/*
Java solution for the problem Maximizing (And Minimizing) Your Winnings (https://open.kattis.com/problems/maximizingwinnings)
Execution time: 1.42 s
Submitted on 2017-10-19 22:50:37
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;
import java.io.*;

public class Solution
{
    static int max(int vertex,int left)
    {
        if(left==0)
        {
            return 0;
        }
        if(memoMax[vertex][left]!=-1)
        {
            return memoMax[vertex][left];
        }
        int res=0;
        for(int i=0;i<n;i++)
        {
            res=Math.max(res,arr[vertex][i]+max(i,left-1));
        }
        return memoMax[vertex][left]=res;
    }
    static int min(int vertex,int left)
    {
        if(left==0)
        {
            return 0;
        }
        if(memoMin[vertex][left]!=-1)
        {
            return memoMin[vertex][left];
        }
        int res=Integer.MAX_VALUE;
        for(int i=0;i<n;i++)
        {
            res=Math.min(res,arr[vertex][i]+min(i,left-1));
        }
        return memoMin[vertex][left]=res;
    }
    static int n;
    static int[][] arr;
    static int[][] memoMax;
    static int[][] memoMin;
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            n=sc.nextInt();
            if(n==0)
                break;
            arr=new int[n][n];
            for(int i=0;i<n;i++)
                for(int j=0;j<n;j++)
                    arr[i][j]=sc.nextInt();
            int k=sc.nextInt();
            memoMax=new int[n][k+1];
            for(int[] tmp : memoMax)
                Arrays.fill(tmp,-1);
            System.out.print(max(0,k)+" ");
            memoMin=new int[n][k+1];
            for(int[] tmp : memoMin)
                Arrays.fill(tmp,-1);
            System.out.println(min(0,k));
        }
    }
}