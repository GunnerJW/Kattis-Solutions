/*
Java solution for the problem Freckles (https://open.kattis.com/problems/freckles)
Execution time: 1.94 s
Submitted on 2018-04-30 22:59:24
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;


public class Solution {
    static class Point//Overload == and < + implement use of epsilon
    {
	private double x,y;
	public Point(double a,double b)
	{
		x=a;
		y=b;
	}
	public double getX()
	{
		return x;
	}
	public double getY()
	{
		return y;
	}
	public boolean equals(Point p)
	{
		if(this.getX()==p.getX() && this.getY()==p.getY())
			return true;
		return false;
	}
	public double distance(Point p)
	{
		double x=this.getX()-p.getX();
		double y=this.getY()-p.getY();
		return x*x+y*y;
	}
}
    static class GraphWeighted
    {
	private ArrayList<Edge> edgeList;
    private int v;
	public static class Edge
	{
		private double w;
		private int v1;
		private int v2;
		public Edge(double w,int v1,int v2)
		{
			this.w=w;
			this.v1=v1;
			this.v2=v2;
		}
		public double w(){
			return w;
		}
		public int v1(){
			return v1;
		}
		public int v2(){
			return v2;
		}
		public static Comparator<Edge> edgeComparator=Comparator.comparingDouble(Edge::w).thenComparingInt(Edge::v1).thenComparingInt(Edge::v2);
	}
	public GraphWeighted(int v,int e)
	{
		edgeList=new ArrayList<Edge>(e);
        this.v=v;
	}
	public void add(int a,int b,double w)
	{
		edgeList.add(new Edge(w,a,b));
	}
	public void sortEdgeList()
	{
		edgeList.sort(Edge.edgeComparator);
		return;
	}
	public ArrayList<Edge> getEdgeList()
	{
		return edgeList;
	}
	public double mstKruskal()
	{
		double x=0;
		UnionFind uf=new UnionFind(v);
		this.sortEdgeList();
		for(Edge e:edgeList)
		{
			if(uf.disjointSets()==1)
				break;
			if(uf.find(e.v1())!=uf.find(e.v2()))
			{
				uf.unite(e.v1(), e.v2());
				x+=Math.sqrt(e.w());
			}
		}
		return x;
	}
}
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
	public int find(int x)//handle x>=n case
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
	public int getNumberOfVertices(int x)
	{
		return numberOfVertices[find(x)];
	}
	
}
    static class Reader
    {
        final private int BUFFER_SIZE = 1 << 16;
        private DataInputStream din;
        private byte[] buffer;
        private int bufferPointer, bytesRead;
 
        public Reader()
        {
            din = new DataInputStream(System.in);
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[64]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
        }
 
        public int nextInt() throws IOException
        {
            int ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do
            {
                ret = ret * 10 + c - '0';
            }  while ((c = read()) >= '0' && c <= '9');
 
            if (neg)
                return -ret;
            return ret;
        }
 
        public long nextLong() throws IOException
        {
            long ret = 0;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
            if (neg)
                return -ret;
            return ret;
        }
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
            byte c = read();
            while (c <= ' ')
                c = read();
            boolean neg = (c == '-');
            if (neg)
                c = read();
 
            do {
                ret = ret * 10 + c - '0';
            }
            while ((c = read()) >= '0' && c <= '9');
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
            if (neg)
                return -ret;
            return ret;
        }
 
        private void fillBuffer() throws IOException
        {
            bytesRead = din.read(buffer, bufferPointer = 0, BUFFER_SIZE);
            if (bytesRead == -1)
                buffer[0] = -1;
        }
 
        private byte read() throws IOException
        {
            if (bufferPointer == bytesRead)
                fillBuffer();
            return buffer[bufferPointer++];
        }
 
        public void close() throws IOException
        {
            if (din == null)
                return;
            din.close();
        }
    }
    public static void main(String[] args) throws IOException{
        Reader sc=new Reader();
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            sc.readLine();
            int v=sc.nextInt();
            Point[] arr=new Point[v];
            for(int j=0;j<v;j++)
                arr[j]=new Point(sc.nextDouble(),sc.nextDouble());
            GraphWeighted g=new GraphWeighted(v,v*(v-1)/2);
            for(int j=0;j<v-1;j++)
                for(int k=j+1;k<v;k++)
                    g.add(j,k,arr[j].distance(arr[k]));
            System.out.printf("%.2f\n\n",g.mstKruskal());
        }
    }
}