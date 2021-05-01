/*
Java solution for the problem Pick up sticks (https://open.kattis.com/problems/pickupsticks)
Execution time: 0.58 s
Submitted on 2017-09-24 17:48:21
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;
import java.io.*;

public class Solution {
    
    static class Graph
    {
	private ArrayList<ArrayList<Integer>> adjList;
	public boolean[] visited;
	public ArrayDeque<Integer> q;
    public boolean cyclic;
    public HashSet<Integer> recursionSet;
	public Graph(int n)
	{
		visited=new boolean[n];
        cyclic=false;
		q=new ArrayDeque<Integer>(n);
        recursionSet=new HashSet<Integer>(n);
		adjList=new ArrayList<ArrayList<Integer>>(n);
		for(int i=0;i<n;i++)
            adjList.add(new ArrayList<Integer>());
	}
	public void add(int i,int j)
	{
        adjList.get(i).add(j);
        //adjList.get(j).add(i);
        return;
    }
    public void dfs(int v)
    {
        //System.out.println("DFS "+v+" called");
        if(recursionSet.contains(v))
        {
            cyclic=true;
            //System.out.println("cycle at "+v+"!");
            return;
        }
        if(visited[v])
            return;
        recursionSet.add(v);
        visited[v]=true;
        for(int i=0;i<adjList.get(v).size();i++)
            this.dfs(adjList.get(v).get(i));
        q.add(v);
        recursionSet.remove(v);
        return;
    }
	/*public ArrayDeque<Integer> topoSort()
    {
        int n=visited.length;
        for(int i=0;i<n;i++)
        {
            
        }
    }*/
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
    public static void main(String args[]) throws IOException
    {
        Reader sc=new Reader();
        int v=sc.nextInt();
        int e=sc.nextInt();
        Graph g=new Graph(v);
        for(int i=0;i<e;i++)
            g.add(sc.nextInt()-1,sc.nextInt()-1);
        boolean broken=false;
        for(int i=0;i<v;i++)
        {
            if(g.visited[i]==false)
            {
                g.dfs(i);
                if(g.cyclic==true)
                {
                    System.out.println("IMPOSSIBLE");
                    broken=true;
                    break;
                }
            }
        }
        if(broken==false)
        {
            StringBuilder output=new StringBuilder();
            for(int i=0;i<v;i++)
            {
                output.append(g.q.pollLast()+1);
                if(i<v-1)
                    output.append("\n");
            }
            System.out.println(output.toString());
        }
    }
}
 