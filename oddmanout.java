/*
Java solution for the problem Odd Man Out (https://open.kattis.com/problems/oddmanout)
Execution time: 0.23 s
Submitted on 2017-02-22 08:51:42
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        int n=0;
        int i=0,j=0,occ=1;
        for(i=0;i<t;i++)
        {
            n=sc.nextInt();
            int arr[]=new int[n];
            for(j=0;j<n;j++)
                arr[j]=sc.nextInt();
            Arrays.sort(arr);
            for(j=0;j<n;j++)
            {
                if(j==n-1 && occ==1)
                {
                    occ=1;
                    System.out.println("Case #"+(i+1)+": "+arr[n-1]);
                    break;
                }
                if(arr[j]==arr[j+1])
                    occ++;
                else
                {
                    if(occ==2)
                        occ=1;
                    else
                    {
                        occ=1;
                        System.out.println("Case #"+(i+1)+": "+arr[j]);
                        break;
                    }
                }
            }
        }
    }
}