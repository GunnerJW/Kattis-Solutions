/*
Java solution for the problem Tri Tiling (https://open.kattis.com/problems/tritiling)
Execution time: 0.07 s
Submitted on 2018-05-05 01:27:22
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static int ways(int i)
    {
        if(i%2==1)
            return 0;
        if(i==0)
            return 1;
        if(memo[i]!=-1)
            return memo[i];
        int res=3*ways(i-2);
        for(int x=4;i>=x;x+=2)
            res+=2*ways(i-x);
        return memo[i]=res;
    }
    static int[] memo;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        memo=new int[31];
        Arrays.fill(memo,-1);
        int n=sc.nextInt();
        while(n!=-1)
        {
            System.out.println(ways(n));
            n=sc.nextInt();
        }
    }
}
