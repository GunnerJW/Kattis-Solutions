/*
Java solution for the problem Squawk Virus (https://open.kattis.com/problems/squawk)
Execution time: 0.18 s
Submitted on 2017-05-12 21:20:10
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static class Graph
    {
	private ArrayList<ArrayList<Integer>> adjList;
    private long squawks;
    private long[] sq;
	public Graph(int n)
	{
		adjList=new ArrayList<ArrayList<Integer>>(n);
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<Integer>(n));
        sq=new long[n];
        squawks=0;
	}
    public void add(int i,int j)
    {
        adjList.get(i).add(j);
        adjList.get(j).add(i);
        return;
    }
    public void run(int s,int t)
    {
        sq[s]=1;
        for(int i=0;i<t;i++)
        {
            long[] tmp=Arrays.copyOf(sq,sq.length);
            for(int j=0;j<sq.length;j++)
            {
                for(int x: adjList.get(j))
                    sq[x]+=tmp[j];
                sq[j]-=tmp[j];
            }
        }
        for(long x : sq)
            squawks+=x;
        System.out.println(squawks);
    }
}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt(),e=sc.nextInt(),s=sc.nextInt(),t=sc.nextInt();
        Graph g=new Graph(v);
        for(int i=0;i<e;i++)
            g.add(sc.nextInt(),sc.nextInt());
        g.run(s,t);
    }
}