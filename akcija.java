/*
Java solution for the problem Akcija (https://open.kattis.com/problems/akcija)
Execution time: 0.49 s
Submitted on 2017-03-11 22:29:37
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),i=0;
        int[] arr=new int[n];
        for(i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
        }
        Arrays.sort(arr);
        int sum=0;
        i=1;
        while(n-i>=0)
        {
            if(i%3==1 || i%3==2)
                sum+=arr[n-i];
            i++;
        }
        System.out.print(sum);
      }
}