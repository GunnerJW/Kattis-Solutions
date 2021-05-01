/*
Java solution for the problem e-Coins (https://open.kattis.com/problems/ecoins)
Execution time: 1.09 s
Submitted on 2017-09-13 04:08:13
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    final static int INF=100_000; 
    static int coins;
    static int target;
    static ArrayList<Integer> conv;
    static ArrayList<Integer> infotech;
    static int size;
    static int[][] memo;
    static int run(int x,int y)
    {
        if(x*x+y*y==target*target)
            return 0;
        if(x*x+y*y>target*target)
            return INF;
        if(memo[x][y]!=-1)
            return memo[x][y];
        int min=INF;
        for(int i=0;i<size;i++)
            min=Math.min(min,1+run(x+conv.get(i),y+infotech.get(i)));
        return memo[x][y]=min;
    }
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            coins=sc.nextInt();
            target=sc.nextInt();
            conv=new ArrayList<Integer>(coins);
            infotech=new ArrayList<Integer>(coins);
            for(int j=0;j<coins;j++)
            {
                int a=sc.nextInt();
                int b=sc.nextInt();
                if(a!=0 || b!=0)
                {
                    conv.add(a);
                    infotech.add(b);
                }
            }
            size=conv.size();
            memo=new int[target][target];
            for(int[] tmp : memo)
                Arrays.fill(tmp,-1);
            /*System.out.println(conv); 
            System.out.println(infotech);*/
            int result=run(0,0);
            if(result==INF) 
                System.out.println("not possible");
            else
                System.out.println(result);
            if(i<t-1)
            {
                sc.nextLine();
                sc.nextLine();
            }
        }
        //System.out.print(output.toString());
    }
}
