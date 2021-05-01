/*
Java solution for the problem Get Shorty (https://open.kattis.com/problems/getshorty)
Execution time: 1.34 s
Submitted on 2017-05-12 23:57:12
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    static class GraphWeighted
    {
	private ArrayList<ArrayList<Pair>> adjListW;
	static class Pair
	{
		private int v;
		private double w;
		public Pair(int a,double b)
		{
			v=a;
			w=b;
		}
		public int v()
		{
			return v;
		}
		public double w()
		{
			return w;
		}
		public static Comparator<Pair> pairComparator=Comparator.comparingInt(Pair::v).thenComparingDouble(Pair::w);
	}
    private static class Pair2
	{
		private double v;
		private int w;
		public Pair2(double a,int b)
		{
			v=a;
			w=b;
		}
		public double v()
		{
			return v;
		}
		public int w()
		{
			return w;
		}
		public static Comparator<Pair2> pair2Comparator=Comparator.comparingDouble(Pair2::v).thenComparingInt(Pair2::w);
	}
	public GraphWeighted(int v)
	{
		adjListW=new ArrayList<ArrayList<Pair>>(v);
		for(int i=0;i<v;i++)
			adjListW.add(new ArrayList<Pair>());
	}
	public void add(int a,int b,double w)
	{
		adjListW.get(a).add(new Pair(b,w));
		adjListW.get(b).add(new Pair(a,w));
	}
	public double[] dijkstra(int x)//does not support graphs with negative-weight cycles
	{
		double[] distance=new double[adjListW.size()];
		Arrays.fill(distance, 1000000000);
		distance[x]=0;
		PriorityQueue<Pair2> pq=new PriorityQueue<Pair2>(adjListW.size(),Pair2.pair2Comparator);
		pq.add(new Pair2(0,x));
		while(!pq.isEmpty())
		{
			Pair2 tmp=pq.poll();
			double d=tmp.v();
			int v=tmp.w();
			if(d>distance[v])
				continue;
			for(Pair p:adjListW.get(v))
			{
				double tmp1=p.w()+d;
				int tmp2=p.v();
				if(tmp1<distance[tmp2])
				{
					distance[tmp2]=tmp1;
					pq.add(new Pair2(tmp1,tmp2));
				}
			}
		}
		return distance;
	}
}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(sc.hasNext())
        {
            int v=sc.nextInt(),e=sc.nextInt();
            if(v==0 && e==0)
                break;
            GraphWeighted g=new GraphWeighted(v);
            for(int i=0;i<e;i++)
                g.add(sc.nextInt(),sc.nextInt(),-1*Math.log(sc.nextDouble()));
            System.out.printf("%.4f\n",Math.exp(-1*g.dijkstra(0)[v-1]));
        }
    }
}