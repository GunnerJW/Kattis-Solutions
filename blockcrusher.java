/*
Java solution for the problem Block Crusher (https://open.kattis.com/problems/blockcrusher)
Execution time: 0.46 s
Submitted on 2017-09-26 02:27:06
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
	}
	public int[] dijkstra(int x)
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
                    parent[tmp2]=v;
				}
			}
		}
		return distance;  
	}
}
    static void update(int node)
    {
        if(node==r*c+1)
        {
            update(parent[node]);
            return;
        }
        if(node==r*c)
        {
            return;
        }
        arr[node/c][node%c]=" ";
        update(parent[node]);
        return;
    }
    static int[] parent;
    static int c;
    static int r;
    static int[] x={-1,-1,0,1,1,1,0,-1};
    static int[] y={0,1,1,1,0,-1,-1,-1};
    static String[][] arr;
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            r=sc.nextInt();
            c=sc.nextInt();
            if(r==0 && c==0)
                break;
            sc.nextLine();
            GraphWeighted g=new GraphWeighted(r*c+2);
            arr=new String[r][c];
            for(int i=0;i<r;i++)
                arr[i]=sc.nextLine().split("");
            for(int i=0;i<r;i++)
                for(int j=0;j<c;j++)
                {
                    for(int k=0;k<8;k++)
                    {
                        int ii=i+x[k];
                        int jj=j+y[k];
                        if(ii>=0 && ii<r && jj>=0 && jj<c)
                            g.add(i*c+j,ii*c+jj,Integer.parseInt(arr[ii][jj]));
                    }
                }
            for(int i=0;i<c;i++)
                g.add(r*c,i,Integer.parseInt(arr[0][i]));
            for(int i=0;i<c;i++)
                g.add((r-1)*c+i,r*c+1,0);
            parent=new int[r*c+2];
            int[] result=g.dijkstra(r*c);
            update(r*c+1);
            //System.out.println();
            StringBuilder output=new StringBuilder();
            for(int i=0;i<r;i++)
            {
                for(int j=0;j<c;j++)
                {
                    output.append(arr[i][j]);
                }
                output.append("\n");
            }
            System.out.println(output.toString());
        }
        //System.out.println(g.topoSort);
    }
}
