/*
Java solution for the problem Minimum Spanning Tree (https://open.kattis.com/problems/minspantree)
Execution time: 1.76 s
Submitted on 2017-05-12 22:12:10
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static class UnionFind
    {
	private int[] parent,rank,numberOfVertices;
	private int dS;
	public UnionFind(int n)
	{
		parent=new int[n];
		rank=new int[n];
		numberOfVertices=new int[n];
		for(int i=0;i<n;i++)
			parent[i]=i;
		Arrays.fill(numberOfVertices, 1);
		dS=n;
	}
	public int find(int x)
	{
		if(parent[x]==x)
			return x;
		return parent[x]=find(parent[x]);
	}
	public void unite(int a,int b)
	{
		int pa=this.find(a),pb=this.find(b);
		if(pa!=pb)
		{
			if(rank[pa]==rank[pb])
			{
				parent[pa]=pb;
				rank[pb]++;
				numberOfVertices[pb]+=numberOfVertices[pa];
			}
			else if(rank[pa]>rank[pb])
			{
				parent[pb]=pa;
				numberOfVertices[pa]+=numberOfVertices[pb];
				}
			else
			{
				parent[pa]=pb;
				numberOfVertices[pb]+=numberOfVertices[pa];
			}
			dS--;
		}
	}
	public int disjointSets()
	{
		return dS;
	}
	}
    public static class Pair
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
    static class GraphWeighted
    {
    private boolean isPossible;
	private int vertices;
    private int mstcost;
    private ArrayList<Pair> al;
	private ArrayList<ArrayList<Pair>> adjListW;
	private ArrayList<Edge> edgeList;
	public static class Edge
	{
		private int w;
		private int v1;
		private int v2;
		public Edge(int w,int v1,int v2)
		{
			this.w=w;
			this.v1=v1;
			this.v2=v2;
		}
		public int w(){
			return w;
		}
		public int v1(){
			return v1;
		}
		public int v2(){
			return v2;
		}
		public static Comparator<Edge> edgeComparator=Comparator.comparingInt(Edge::w).thenComparingInt(Edge::v1).thenComparingInt(Edge::v2);
	}
	public GraphWeighted(int v,int e)
	{
        mstcost=0;
        isPossible=true;
        al=new ArrayList<Pair>(e);
		vertices=v;
		adjListW=new ArrayList<ArrayList<Pair>>(v);
		for(int i=0;i<v;i++)
			adjListW.add(new ArrayList<Pair>());
		edgeList=new ArrayList<Edge>(e);
	}
	public void add(int a,int b,int w)
	{
		adjListW.get(a).add(new Pair(b,w));
		adjListW.get(b).add(new Pair(a,w));
		edgeList.add(new Edge(w,a,b));
	}
	public void sortEdgeList()
	{
		Collections.sort(edgeList,Edge.edgeComparator);
		return;
	}
	public void mstKruskal()
	{
		UnionFind uf=new UnionFind(vertices);
		this.sortEdgeList();
		for(Edge e:edgeList)
		{
			if(uf.disjointSets()==1)
				break;
            int x1=e.v1(),x2=e.v2();
			if(uf.find(x1)!=uf.find(x2))
			{
                al.add(new Pair(Math.min(x1,x2),Math.max(x1,x2)));
				uf.unite(x1,x2);
				mstcost+=e.w();
			}
		}
		if(uf.disjointSets()!=1)
		    isPossible=false;
        return;
	}
	public boolean isp()
	{
	    return isPossible;
	}
    public int mstcost(){
        return mstcost;
    }
    public ArrayList<Pair> getal(){
        return al;
    }
}
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),m=sc.nextInt();
        while(n!=0 || m!=0)
        {
            GraphWeighted g=new GraphWeighted(n,m);
            for(int i=0;i<m;i++)
                g.add(sc.nextInt(),sc.nextInt(),sc.nextInt());
            g.mstKruskal();
            //System.out.println(g.mstcost());
            int mstcost=g.mstcost();
            if(mstcost==0 || g.isp()==false)
                System.out.println("Impossible");
            else
            {
                ArrayList<Pair> al=new ArrayList<Pair>(g.getal());
                Collections.sort(al,Pair.pairComparator);
                System.out.println(mstcost);
                for(Pair p:al)
                    System.out.println(p.v()+" "+p.w());
            }
            n=sc.nextInt();
            m=sc.nextInt();
        }
    }
}