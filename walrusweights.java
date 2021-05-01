/*
Java solution for the problem Walrus Weights (https://open.kattis.com/problems/walrusweights)
Execution time: 0.64 s
Submitted on 2017-09-14 02:24:45
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static int n;
    static int[] weights;
    static ArrayList<HashMap<Integer,Integer>> memo;
    static int minDiff(int index,int curr)
    {
        if(index==n)
            return curr-1000;
        if(curr>=1000)
            return curr-1000;
        if(memo.get(index).containsKey(curr))
            return memo.get(index).get(curr);
        int a=minDiff(index+1,curr+weights[index]);
        int b=minDiff(index+1,curr);
        if((int)Math.abs(a)==(int)Math.abs(b))
        {
            memo.get(index).put(curr,Math.max(a,b));
            return Math.max(a,b);        
        }
        else if((int)Math.abs(a)<(int)Math.abs(b))
        {
            memo.get(index).put(curr,a);
            return a;
        }
        memo.get(index).put(curr,b);
        return b;       
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        n=sc.nextInt();
        weights=new int[n];
        for(int i=0;i<n;i++)
            weights[i]=sc.nextInt();
        memo=new ArrayList<HashMap<Integer,Integer>>(n);
        for(int i=0;i<n;i++)
            memo.add(new HashMap<Integer,Integer>());
        System.out.println(minDiff(0,0)+1000);
    }
}
