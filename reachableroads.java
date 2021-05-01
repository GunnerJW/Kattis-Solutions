/*
Java solution for the problem Reachable Roads (https://open.kattis.com/problems/reachableroads)
Execution time: 0.07 s
Submitted on 2017-04-07 02:57:08
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;


public class Solution {
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

    static class Ufds
    {
	private int[] parent,rank;
	private int dS;
	public Ufds(int n)
	{
		parent=new int[n];
		rank=new int[n];
		for(int i=0;i<n;i++)
			parent[i]=i;
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
			}
			else if(rank[pa]>rank[pb])
				parent[pb]=pa;
			else
				parent[pa]=pb;
			dS--;
		}
	}
	public int disjointSets()
	{
		return dS;
	}
}
    public static void main(String[] args) throws IOException{
        Reader sc = new Reader();
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int n=sc.nextInt();
            Ufds uf=new Ufds(n);
            int q=sc.nextInt();
            for(int j=0;j<q;j++)
            {
                uf.unite(sc.nextInt(),sc.nextInt());
            }
            System.out.println(uf.disjointSets()-1);
        }
    }
}

