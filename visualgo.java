/*
Java solution for the problem VisuAlgo Online Quiz (https://open.kattis.com/problems/visualgo)
Execution time: 0.64 s
Submitted on 2017-09-21 19:05:36
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static int[] paths_num;
    static class Pair
	{
		private int v;
		private int w;
		public Pair(int a,int b)
		{
			v=a;
			w=b;
		}
		public int v()
		{
			return v;
		}
		public int w()
		{
			return w;
		}
        @Override
        public String toString()
        {
            return "("+this.v()+","+this.w()+")";
        }
		public static Comparator<Pair> pairComparator=Comparator.comparingInt(Pair::v).thenComparingInt(Pair::w);
	}
    static class GraphWeighted
    {
	public ArrayList<ArrayList<Pair>> adjListW;
	public GraphWeighted(int v)
	{
		adjListW=new ArrayList<ArrayList<Pair>>(v);
		for(int i=0;i<v;i++)
			adjListW.add(new ArrayList<Pair>());
	}
	public void add(int a,int b,int w)
	{
		adjListW.get(a).add(new Pair(b,w));
	}
	public void dijkstra(int x)
	{
		int[] distance=new int[adjListW.size()];
		Arrays.fill(distance, 1_000_000_000);
		distance[x]=0;
		PriorityQueue<Pair> pq=new PriorityQueue<Pair>(adjListW.size(),Pair.pairComparator);
		pq.add(new Pair(0,x));
        paths_num[x]=1;
		while(!pq.isEmpty())
		{
			Pair tmp=pq.poll();
			int d=tmp.v();
			int v=tmp.w();
			if(d>distance[v])
				continue;
			for(Pair p:adjListW.get(v))
			{
				int tmp1=p.w()+d;
				int tmp2=p.v();
                if(tmp1==distance[tmp2])
                {
                    paths_num[tmp2]+=paths_num[v];
                }
				else if(tmp1<distance[tmp2])
				{
					distance[tmp2]=tmp1;
					pq.add(new Pair(tmp1,tmp2));
                    paths_num[tmp2]=paths_num[v];
				}
			}
		}
        return;
	}
}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        int e=sc.nextInt();
        GraphWeighted g=new GraphWeighted(v);
        for(int i=0;i<e;i++)
            g.add(sc.nextInt(),sc.nextInt(),sc.nextInt());
        int s=sc.nextInt();
        int d=sc.nextInt();
        paths_num=new int[v];
        g.dijkstra(s);
        System.out.println(paths_num[d]);
    }
}