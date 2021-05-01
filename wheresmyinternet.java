/*
Java solution for the problem Where's My Internet?? (https://open.kattis.com/problems/wheresmyinternet)
Execution time: 0.74 s
Submitted on 2017-04-02 15:50:17
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;
import java.io.*;

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
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[1000000]; // line length
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
    
    static class Ufds
    {
	private int[] parent,rank;
	public Ufds(int n)
	{
		parent=new int[n];
		rank=new int[n];
		for(int i=0;i<n;i++)
		{
			parent[i]=i;
			rank[i]=0;
		}
	}
	public int find(int x)
	{
		if(parent[x]==x)
			return x;
		return find(parent[x]);
	}
	public void unite(int a,int b) //must add path-compression
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
		}
	}
	public void printParents(){
		System.out.print(Arrays.toString(parent));}
	public void printRanks(){
		System.out.print(Arrays.toString(rank));}
}
    
    public static void main(String[] args) throws IOException{
        Reader sc=new Reader();
        int n=sc.nextInt(),m=sc.nextInt(),i;
        Ufds uf=new Ufds(n);
        for(i=0;i<m;i++)
            uf.unite(sc.nextInt()-1,sc.nextInt()-1);
        //uf.printParents();
        int nonConnected=0;
        int first=uf.find(0);
        for(i=1;i<n;i++)
        {
            if(uf.find(i)!=first)
            {
                System.out.println(i+1);
                nonConnected++;
            }
        }
        if(nonConnected==0)
            System.out.println("Connected");
      }
}