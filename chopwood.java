/*
Java solution for the problem Chopping Wood (https://open.kattis.com/problems/chopwood)
Execution time: 0.76 s
Submitted on 2018-05-08 20:15:30
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        StringBuilder out=new StringBuilder();
        int[] arr=new int[n+1];
        boolean error=false;
        int[] seq=new int[n];
        for(int i=0;i<n;i++)
        {
            int x=sc.nextInt()-1;
            arr[x]++;
            seq[i]=x;
            if(i==n-1 && x!=n)
            {
                error=true;
                break;
            }
        }
        if(error)
            System.out.println("error");
        else
        {
            PriorityQueue<Integer> q=new PriorityQueue<Integer>(n);
            for(int i=0;i<n+1;i++)
                if(arr[i]==0)
                    q.add(i);
            for(int i=0;i<n;i++)
            {
                out.append(q.remove()+1);
                if(i<n-1)
                    out.append("\n");
                arr[seq[i]]--;
                if(arr[seq[i]]==0)
                    q.add(seq[i]);
            }
            System.out.println(out);
        }
    }
}
