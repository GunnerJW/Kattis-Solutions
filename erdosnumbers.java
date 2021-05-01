/*
Java solution for the problem Erdős Numbers (https://open.kattis.com/problems/erdosnumbers)
Execution time: 0.4 s
Submitted on 2017-09-20 21:03:43
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    static class GraphWeighted
    {
	private ArrayList<ArrayList<Pair>> adjListW;
	private static class Pair
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
		public static Comparator<Pair> pairComparator=Comparator.comparingInt(Pair::v).thenComparingInt(Pair::w);
	}
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
		Arrays.fill(distance, 1000000000);
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
				if(tmp1<distance[tmp2])
				{
					distance[tmp2]=tmp1;
					pq.add(new Pair(tmp1,tmp2));
				}
			}
		}
		return distance;
	}
}


    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        ArrayList<String[]> input=new ArrayList<String[]>();
        HashSet<String> vertices=new HashSet<String>();
        ArrayList<String> queries=new ArrayList<String>();
        while(sc.hasNext())
        {
            String[] arr=sc.nextLine().split(" ");
            queries.add(arr[0]);
            for(String x : arr)
                vertices.add(x);
            input.add(arr);
        }
        int v=vertices.size();
        HashMap<String,Integer> hm=new HashMap<String,Integer>(v);
        int verticeId=0;
        for(String s : vertices)
            hm.put(s,verticeId++);
        GraphWeighted g=new GraphWeighted(v);
        for(int i=0;i<input.size();i++)
            for(int j=1;j<input.get(i).length;j++)
                g.add(hm.get(queries.get(i)),hm.get(input.get(i)[j]),1);
        int[] erdosNumbers=g.dijkstra(hm.get("PAUL_ERDOS"));
        StringBuilder output=new StringBuilder();
        for(String s : queries)
        {
            int en=erdosNumbers[hm.get(s)];
            if(en==1000000000)
                output.append(s+" no-connection\n");
            else
                output.append(s+" "+en+"\n");
        }
        System.out.print(output.toString());
    }
}

