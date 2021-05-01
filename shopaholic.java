/*
Java solution for the problem Shopaholic (https://open.kattis.com/problems/shopaholic)
Execution time: 0.6 s
Submitted on 2017-05-14 00:18:49
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

public class Solution{
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        for(int i=0;i<n;i++)
            arr[i]=sc.nextInt();
        Arrays.sort(arr);
        long max=0;
        int curr=n-1;
        while(curr-2>=0)
        {
            max+=arr[curr-2];
            curr-=3;
        }
        System.out.println(max);
    }
}