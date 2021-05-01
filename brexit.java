/*
Java solution for the problem Brexit (https://open.kattis.com/problems/brexit)
Execution time: 0.28 s
Submitted on 2018-07-09 22:55:17
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
 
        // public void close() throws IOException
        // {
        //     if (din == null)
        //         return;
        //     din.close();
        // }
    }
    static class Graph
    {
        public ArrayList<Integer>[] adjacency_list;
        public int[] number_of_partners;
        public boolean[] has_left_union;
        public int n;

        public Graph(int v)
        {
            n=v;
            number_of_partners=new int[v];
            has_left_union=new boolean[v];
            adjacency_list=new ArrayList[v];
            for(int i=0;i<v;i++)
                adjacency_list[i]=new ArrayList<Integer>();
        }

        public void add(int i,int j)
        {
            adjacency_list[i].add(j);
            number_of_partners[i]++;
            adjacency_list[j].add(i);
            number_of_partners[j]++;
            return;
        }

        public boolean run(int first_to_leave,int home_country)
        {
            int[] remaining_partnerships=Arrays.copyOf(number_of_partners,n);
            ArrayDeque<Integer> q=new ArrayDeque<Integer>();
            has_left_union[first_to_leave]=true;
            for(int neighbour:adjacency_list[first_to_leave])
            {
                q.add(neighbour);
                remaining_partnerships[neighbour]--;
            }
            while(!q.isEmpty())
            {
                int country=q.remove();
                if(!has_left_union[country])
                {
                    if(remaining_partnerships[country]<=number_of_partners[country]/2)
                    {
                        has_left_union[country]=true;
                        for(int neighbour:adjacency_list[country])
                        {
                            if(!has_left_union[neighbour])
                            {
                                q.add(neighbour);
                                remaining_partnerships[neighbour]--;
                            }
                        }
                    }
                }
            }
            return has_left_union[home_country];
        }
    }
    public static void main(String[] args) throws IOException{
        Reader r=new Reader();
        int countries=r.nextInt();
        int partnerships=r.nextInt();
        int home_country=r.nextInt()-1;
        int first_to_leave=r.nextInt()-1;
        Graph g=new Graph(countries);
        for(int i=0;i<partnerships;i++)
            g.add(r.nextInt()-1,r.nextInt()-1);
        System.out.println(g.run(first_to_leave,home_country)?"leave":"stay");
    }
}
