/*
Java solution for the problem Money Matters (https://open.kattis.com/problems/moneymatters)
Execution time: 0.08 s
Submitted on 2017-04-02 15:30:40
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
        boolean broken=false;
        int[] balance=new int[n];
        for(i=0;i<n;i++)
            balance[i]=sc.nextInt();
        Ufds uf=new Ufds(n);
        for(i=0;i<m;i++)
        {
            uf.unite(sc.nextInt(),sc.nextInt());
        }
        //uf.printParents();
        Hashtable<Integer,Integer> ht=new Hashtable<Integer,Integer>(n);
        for(i=0;i<n;i++)
        {
            int p=uf.find(i);
            if(ht.containsKey(p))
                ht.put(p,ht.get(p)+balance[i]);
            else
                ht.put(p,balance[i]);
        }
        for(int key : ht.keySet())
        {
            if(ht.get(key)!=0)
            {
                System.out.println("IMPOSSIBLE");
                broken=true;
                break;
            }
        }
        if(broken==false)
            System.out.println("POSSIBLE");
      }
}