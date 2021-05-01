/*
Java solution for the problem Torn To Pieces (https://open.kattis.com/problems/torn2pieces)
Execution time: 0.08 s
Submitted on 2017-09-20 21:00:16
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static HashMap<String,Integer> hm;
    static HashMap<Integer,String> reverse;
    static int[] parent;
    static String start;
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
        adjList.get(j).add(i);
        return;
    }
	public void bfs(int u)//add SSSP
	{
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
                    parent[z]=x;
					visited[z]=true;
				}		
			}
		}
	}
    public boolean isReachable(int v)
    {
        return visited[v];
    }
    public void printPath(int v)
    {
        if(v==hm.get(start))
        {
            System.out.print(start+" ");
            return;
        }
        printPath(parent[v]);
        System.out.print(reverse.get(v)+" ");
        return;
    }
}


    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Graph g=new Graph(n*n);//if vertices are more than n² , IndexOutOfBoundsException may occur with "visited"
        parent=new int[n*n];
        hm=new HashMap<String,Integer>();
        reverse=new HashMap<Integer,String>();
        int v=0;
        sc.nextLine();
        for(int i=0;i<n;i++)
        {
            String[] tmp=sc.nextLine().split(" ");
            int length=tmp.length;
            for(int j=0;j<length;j++)
            {
                if(!hm.containsKey(tmp[j]))
                {
                    hm.put(tmp[j],v);
                    reverse.put(v,tmp[j]);
                    v++;
                }
            }
            for(int j=1;j<length;j++)
            {
                g.add(hm.get(tmp[0]),hm.get(tmp[j]));
            }
        }
        start=sc.next();
        String destination=sc.next();
        if(!hm.containsKey(start) || !hm.containsKey(destination))
            System.out.print("no route found");
        else
        {
            g.bfs(hm.get(start));
            if(g.isReachable(hm.get(destination)))
                g.printPath(hm.get(destination));
            else
                System.out.print("no route found");    
        }
    }
}