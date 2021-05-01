/*
Java solution for the problem Number Sets (https://open.kattis.com/problems/numbersetseasy)
Execution time: 0.32 s
Submitted on 2018-04-30 16:19:25
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
        private int[] parent,rank,numberOfVertices;
        private int dS;
        public Ufds(int n)
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
    static boolean isPrime(int n)
    {
        for(int i=2;i*i<=n;i++)
        {
            if(n%i==0)
                return false;
        }
        return true;
    }    
    static int gcd(int a,int b)
	{
		return b==0?a:gcd(b,a%b);
	}
    static ArrayList<Integer> primeSieve(int n)
	{
		ArrayList<Integer> primes=new ArrayList<Integer>();
		boolean[] crossed=new boolean[n+1];
		crossed[0]=true;
		crossed[1]=true;
		int m=0,i;
		while(m!=n)
		{
			for(i=2;i<n+1;i++)
			{
				if(crossed[i]==false)
				{
					m=i;
					primes.add(m);
					break;
				}
			}
			if(i==n+1) break;
			for(i=m;i<n+1;i+=m)
			{
				crossed[i]=true;
			}
		}
		return primes;
	}
    public static ArrayList<Integer> primeFct(int n,ArrayList<Integer> primes)// handle n<=1
	{
		ArrayList<Integer> al=new ArrayList<Integer>();
		int i=0,tmp=n;
		int pf=primes.get(i);
		while(pf*pf<=tmp)
		{
			while(tmp%pf==0)
			{
				tmp/=pf;
				al.add(pf);
			}
			i++;
			if(i>=primes.size()) break;
			pf=primes.get(i);
		}
		if(tmp!=1)
		{
			al.add(tmp);
		}
		return al;
	}
    public static void main(String[] args) throws IOException{
        Reader sc=new Reader();
        int t=sc.nextInt();
        ArrayList<Integer> primes=primeSieve(31);
        for(int i=0;i<t;i++)
        {
            int a=sc.nextInt();
            int b=sc.nextInt();
            int p=sc.nextInt();
            Ufds uf=new Ufds(b-a+1);
            for(int j=a;j<b;j++)
                for(int k=j+1;k<=b;k++)
                {
                    int gcd=gcd(j,k);
                    //System.out.println(j+" and "+k+" : "+gcd);
                    ArrayList<Integer> primeFct=primeFct(gcd,primes);
                    //System.out.println(primeFct);
                    int pos=Collections.binarySearch(primeFct,p);
                    if(pos<0)
                        pos=-pos-1;
                    //System.out.println(pos);
                    if(pos<primeFct.size())
                        uf.unite(j-a,k-a);
                }
            System.out.println("Case #"+(i+1)+": "+uf.disjointSets());
            //System.out.println(primeSieve(1000).size());
        }
        // ArrayList<Integer> primes=primeSieve(31);
        // System.out.println(primeFct(1000,primes));
    }
}