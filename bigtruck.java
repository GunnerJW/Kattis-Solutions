/*
Java solution for the problem Big Truck (https://open.kattis.com/problems/bigtruck)
Execution time: 0.29 s
Submitted on 2017-09-20 21:00:57
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static int[] items;
    static ArrayList<PriorityQueue<Pair>> parents;
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
		adjListW.get(b).add(new Pair(a,w));
	}
	public int[] dijkstra(int x)//does not support graphs with negative-weight cycles
	{
		int[] distance=new int[adjListW.size()];
		Arrays.fill(distance, 1_000_000_000);
		distance[x]=0;
		PriorityQueue<Pair> pq=new PriorityQueue<Pair>(adjListW.size(),Pair.pairComparator);
		pq.add(new Pair(0,x));
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
                    Pair aux=parents.get(v).peek();
                    //System.out.println((tmp2+1)+" -> ("+(aux.v()+items[tmp2])+","+(v+1)+")");
                    parents.get(tmp2).add(new Pair(aux.v()+items[tmp2],v));
                }
				if(tmp1<distance[tmp2])
				{
					distance[tmp2]=tmp1;
					pq.add(new Pair(tmp1,tmp2));
                    parents.get(tmp2).clear();
                    Pair aux=parents.get(v).peek();
                    //System.out.println("clear -> "+(tmp2+1)+" -> ("+(aux.v()+items[tmp2])+","+(v+1)+")");
                    parents.get(tmp2).add(new Pair(aux.v()+items[tmp2],v));
				}
			}
		}
		return distance;
	}
}
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        items=new int[v];
        for(int i=0;i<v;i++)
            items[i]=sc.nextInt();
        int e=sc.nextInt();
        GraphWeighted g=new GraphWeighted(v);
        for(int i=0;i<e;i++)
            g.add(sc.nextInt()-1,sc.nextInt()-1,sc.nextInt());
        parents=new ArrayList<PriorityQueue<Pair>>(v);
        for(int i=0;i<v;i++)
            parents.add(new PriorityQueue<Pair>(Comparator.comparing(Pair::v,Comparator.reverseOrder())));
        parents.get(0).add(new Pair(items[0],0));
        int[] sp=g.dijkstra(0);
        if(sp[v-1]==1_000_000_000)
            System.out.println("impossible");
        else
            System.out.println(sp[v-1]+" "+parents.get(v-1).peek().v());
    }
}