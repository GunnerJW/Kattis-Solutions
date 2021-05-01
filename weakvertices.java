/*
Java solution for the problem Weak Vertices (https://open.kattis.com/problems/weakvertices)
Execution time: 0.23 s
Submitted on 2017-02-25 22:13:19
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int i=0,j=0,k=0,s;
        while(n!=-1)
        {
            int[][] arr=new int[n][n];
            for(i=0;i<n;i++)
            {
                for(j=0;j<n;j++)
                {
                    arr[i][j]=sc.nextInt();
                }
            }
            lp:for(i=0;i<n;i++)
            {
                ArrayList<Integer> al=new ArrayList<Integer>(n);
                for(j=0;j<n;j++)
                {
                    if(arr[i][j]==1)
                    {
                        al.add(j);
                    }
                }
                s=al.size();
                for(j=0;j<s-1;j++)
                {
                    for(k=j+1;k<s;k++)
                    {
                        if(arr[al.get(j)][al.get(k)]==1)
                            continue lp;
                    }
                }
                System.out.print(i+" ");            
            }
            System.out.print("\n");
            n=sc.nextInt();
        }
    }
}