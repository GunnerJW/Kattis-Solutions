/*
Java solution for the problem Maximum Flow (https://open.kattis.com/problems/maxflow)
Execution time: 0.44 s
Submitted on 2017-10-20 16:24:12
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;
import java.io.*;

public class Solution
{
    public static class Edge
	{
		public int to;
		public int flow;
		public int capacity;
		public int reverseId;
		public Edge(int t,int rev,int c)
		{
			to=t;
			capacity=c;
			reverseId=rev;
		}
		@Override
		public String toString()
		{
			return to+" "+flow+"/"+capacity+" : "+reverseId;
		}
	}
    static class Dinic2
    {
	public int n;
	public int[] level;
	public List<Edge>[] graph;
	public Dinic2(int v)
	{
		n=v;
		graph=new List[v];
		for(int i=0;i<v;i++)
			graph[i]=new ArrayList<Edge>();
		level=new int[v];
	}
	public void add(int u,int v,int c)
	{
		graph[u].add(new Edge(v,graph[v].size(),c));
		graph[v].add(new Edge(u,graph[u].size()-1,0));
	}
	public boolean bfs(int s,int t)
	{
		Arrays.fill(level, -1);
		level[s]=0;
		ArrayDeque<Integer> q=new ArrayDeque<Integer>();
		q.add(s);
		while(!q.isEmpty())
		{
			int u=q.pollFirst();
			for(Edge e : graph[u])
			{
				if(level[e.to]<0 && e.flow<e.capacity)
				{
					level[e.to]=level[u]+1;
					q.add(e.to);
				}
			}
		}
		//System.out.println(Arrays.toString(level));
		return level[t]>=0;	
	}
	public int sendFlow(int src,int dst,int flow,int[] start)
	{
		if(src==dst)
			return flow;
		for(;start[src]<graph[src].size();++start[src])
		{
			Edge e=graph[src].get(start[src]);
			if(level[e.to]==level[src]+1 && e.flow<e.capacity)
			{
				int curr_flow=Math.min(flow, e.capacity-e.flow);
				int temp_flow=sendFlow(e.to,dst,curr_flow,start);
				if(temp_flow>0)
				{
					e.flow+=temp_flow;
					graph[e.to].get(e.reverseId).flow-=temp_flow;
					return temp_flow;
				}
				
			}
		}
		return 0;
	}
	public int maxFlow(int s,int t)
	{
		if(s==t)
			return -1;
		int res=0;
		while(bfs(s,t))
		{
			int[] start=new int[n];
			while(true)
			{
				int f=sendFlow(s,t,Integer.MAX_VALUE,start);
				if(f==0)
					break;
				res+=f;
			}
		}
		return res;
	}
}

    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        int s=sc.nextInt();
        int t=sc.nextInt();
        Dinic2 g=new Dinic2(v);
        for(int i=0;i<e;i++)
            g.add(sc.nextInt(),sc.nextInt(),sc.nextInt());
        int res=g.maxFlow(s,t);
        ArrayList<Integer> from=new ArrayList<Integer>(v);
        ArrayList<Integer> to=new ArrayList<Integer>(v);
        ArrayList<Integer> flow=new ArrayList<Integer>(v);
        for(int i=0;i<v;i++)
        {
            for(Edge tmp : g.graph[i])
            {
                if(tmp.flow>0)
                {
                    from.add(i);
                    to.add(tmp.to);
                    flow.add(tmp.flow);
                }
            }
        }
        System.out.println(v+" "+res+" "+from.size());
        for(int i=0;i<from.size();i++)
            System.out.println(from.get(i)+" "+to.get(i)+" "+flow.get(i));
    }
}