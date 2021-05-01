/*
Java solution for the problem Reversing Roads (https://open.kattis.com/problems/reversingroads)
Execution time: 0.25 s
Submitted on 2017-09-20 21:02:25
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
	public void dfs(int u)
	{
		if(visited[u])
			return;
		visited[u]=true;
		for(int i=0;i<adjList.get(u).size();i++)
		{
			this.dfs(adjList.get(u).get(i));
		}
	}
	public void reset()
	{
		visited=new boolean[visited.length];
	}
    public int reachable()
    {
        for(boolean b : visited)
            if(b==false)
                return 0;
        return 1;
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
        int it=1;
        while(sc.hasNext())
        {
            System.out.print("Case "+it+": ");
            it++;
            int v=sc.nextInt();
            int e=sc.nextInt();
            int[] from=new int[e];
            int[] to=new int[e];
            Graph g=new Graph(v);
            for(int i=0;i<e;i++)
            {
                int f=sc.nextInt();
                int t=sc.nextInt();
                from[i]=f;
                to[i]=t;
                g.add(f,t);
            }
            boolean broken=false;
            for(int i=0;i<v;i++)
            {
                g.dfs(i);
                if(g.reachable()==0)
                {
                    broken=true;
                    break;
                }
                g.reset();
            }
            if(broken==false)
                System.out.println("valid");
            else
            {
                Graph[] arr=new Graph[e];
                for(int i=0;i<e;i++)
                    arr[i]=new Graph(v);
                for(int i=0;i<e;i++)
                {
                    for(int j=0;j<e;j++)
                    {
                        if(j!=i)
                        {
                            arr[i].add(from[j],to[j]);
                        }
                        else
                        {
                            arr[i].add(to[j],from[j]);
                        }
                    }
                }
                boolean broken2=false;
                for(int i=0;i<e;i++)
                {
                    boolean isValid=true;
                    for(int j=0;j<v;j++)
                    {
                        arr[i].dfs(j);
                        if(arr[i].reachable()==0)
                        {
                            isValid=false;
                            break;
                        }
                        arr[i].reset();
                    }
                    if(isValid==true)
                    {
                        System.out.println(from[i]+" "+to[i]);
                        broken2=true;
                        break;
                    }
                }
                if(broken2==false)
                    System.out.println("invalid");
            }
        }
    }
}
