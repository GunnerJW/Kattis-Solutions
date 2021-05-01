/*
Java solution for the problem Dominoes 2 (https://open.kattis.com/problems/dominoes2)
Execution time: 0.43 s
Submitted on 2017-09-07 03:54:10
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static class Graph
    {
	private ArrayList<ArrayList<Integer>> adjList;
	private boolean[] visited;
	private ArrayDeque<Integer> q;
	public Graph(int n)
	{
		visited=new boolean[n];
		q=new ArrayDeque<Integer>(n);
		adjList=new ArrayList<ArrayList<Integer>>(n);
		for(int i=0;i<n;i++)
            adjList.add(new ArrayList<Integer>());
	}
	public void add(int i,int j)
	{
        adjList.get(i).add(j);
        return;
    }
	public int dfs(int u)
	{
		if(visited[u])
			return 0;
		visited[u]=true;
        int x=1;
		for(int i=0;i<adjList.get(u).size();i++)
		{
			x+=this.dfs(adjList.get(u).get(i));
		}
        return x;
	}
	public void reset()
	{
		visited=new boolean[visited.length];
	}
	public void bfs(int u)
	{
		this.reset();
		q.add(u);
		visited[u]=true;
		while(!q.isEmpty())
		{
			int x=q.remove();
			for(int i=0;i<adjList.get(x).size();i++)
			{
				int z=adjList.get(x).get(i);
				if(!visited[z])
				{
					q.add(z);
					visited[z]=true;
				}		
			}
		}
	}
}

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            int m=sc.nextInt();
            int l=sc.nextInt();
            Graph g=new Graph(n);
            for(int j=0;j<m;j++)
                g.add(sc.nextInt()-1,sc.nextInt()-1);
            int sum=0;
            for(int j=0;j<l;j++)
                sum+=g.dfs(sc.nextInt()-1);
            System.out.println(sum);
        }
    }
}
