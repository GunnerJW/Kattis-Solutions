/*
Java solution for the problem Flying Safely (https://open.kattis.com/problems/flyingsafely)
Execution time: 0.08 s
Submitted on 2017-07-28 02:00:48
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
    private int min=0;
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
            min++;
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
    public int getMin()
    {
        return min;
    }
}

    public static void main(String[] args) throws IOException{
        Reader sc=new Reader();
        int t=sc.nextInt();
        int c,p;
        for(int i=0;i<t;i++)
        {
            c=sc.nextInt();
            p=sc.nextInt();
            Ufds uf=new Ufds(c);
            for(int j=0;j<p;j++)
            {
                uf.unite(sc.nextInt()-1,sc.nextInt()-1);
            }
            System.out.println(uf.getMin());
        }
    }
}
