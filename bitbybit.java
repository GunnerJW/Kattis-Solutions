/*
Java solution for the problem Bit by Bit (https://open.kattis.com/problems/bitbybit)
Execution time: 0.14 s
Submitted on 2017-04-21 18:17:01
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        while(n!=0)
        {
            int[] arr=new int[32];
            Arrays.fill(arr,-1);
            for(int i=0;i<n;i++)
            {
                String s=sc.next();
                if(s.equals("SET"))
                {
                    arr[31-sc.nextInt()]=1;
                }
                else if(s.equals("CLEAR"))
                {
                    arr[31-sc.nextInt()]=0;
                }
                else if(s.equals("AND"))
                {
                    int a=31-sc.nextInt();
                    int b=31-sc.nextInt();
                    if(arr[a]!=-1 && arr[b]!=-1)
                        arr[a]=arr[a]&arr[b];
                    else if(arr[a]==0 || arr[b]==0)
                        arr[a]=0;
                    else
                        arr[a]=-1;
                }
                else
                {
                    int a=31-sc.nextInt();
                    int b=31-sc.nextInt();
                    if(arr[a]!=-1 && arr[b]!=-1)
                        arr[a]=arr[a]|arr[b];
                    else if(arr[a]==1 || arr[b]==1)
                        arr[a]=1;
                    else
                        arr[a]=-1;
                }
            }
            for(int i=0;i<32;i++)
            {
                if(arr[i]==-1)
                    System.out.print("?");
                else
                    System.out.print(arr[i]);
            }
            System.out.println("");
            n=sc.nextInt();
        }
    }
}
