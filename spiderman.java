/*
Java solution for the problem Spiderman's Workout (https://open.kattis.com/problems/spiderman)
Execution time: 0.21 s
Submitted on 2017-09-14 15:27:21
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static int n;
    static int[] d;
    static int[] sums;
    static int[][] dp;
    static String[][] opt;
    static int climb(int index,int h)
    {
        //System.out.println("("+index+","+h+") called");
        if(h<0)
            return -1;
        if(index>n && h!=0)
            return -1;
        if(index>n && h==0)
            return 0;
        if(h+sums[index-1]-sums[n]>0)
            return -1;
        if(dp[index][h]!=-2)
            return dp[index][h];
        int a=climb(index+1,h+d[index]);
        int b=climb(index+1,h-d[index]);
        if(a==-1 && b==-1)
        {
            return dp[index][h]=-1;
        }
        if(a==-1)
        {   
            opt[index][h]=opt[index+1][h-d[index]]+"D";
            return dp[index][h]=Math.max(b,h);
        }
        if(b==-1)
        {
            opt[index][h]=opt[index+1][h+d[index]]+"U";
            return dp[index][h]=Math.max(a,h);
        }
        if(a<=b)
        {
            opt[index][h]=opt[index+1][h+d[index]]+"U";
            return dp[index][h]=Math.max(h,a);    
        }
        opt[index][h]=opt[index+1][h-d[index]]+"D";
        return dp[index][h]=Math.max(h,b);
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            n=sc.nextInt();
            d=new int[n+1];
            sums=new int[n+1];
            d[0]=0;
            sums[0]=0;
            for(int j=1;j<=n;j++)
            {
                d[j]=sc.nextInt();
                sums[j]=d[j]+sums[j-1];
            }
            dp=new int[n+1][sums[n-1]+1];
            for(int[] x : dp)
                Arrays.fill(x,-2);
            opt=new String[n+2][sums[n-1]+1];
            for(String[] x : opt)
                Arrays.fill(x,"");
            /*System.out.println(Arrays.toString(d));
            System.out.println(Arrays.toString(sums));
            System.out.println();*/
            int result=climb(1,0);
            if(result==-1)
                System.out.println("IMPOSSIBLE");
            else
                System.out.println((new StringBuilder(opt[1][0])).reverse().toString());
        }
        //System.out.print(output.toString());
    }
}
