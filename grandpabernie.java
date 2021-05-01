/*
Java solution for the problem Grandpa Bernie (https://open.kattis.com/problems/grandpabernie)
Execution time: 0.67 s
Submitted on 2018-04-30 03:51:47
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.lang.Math;

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
        int n=sc.nextInt();
        HashMap<String,ArrayList> ht=new HashMap<String,ArrayList>(n);
        //sc.readLine();
        for(int i=0;i<n;i++)
        {
            String[] arr=sc.readLine().split(" ");
            if(ht.containsKey(arr[0]))
            {
                ht.get(arr[0]).add(Integer.parseInt(arr[1]));
            }
            else
            {
                ArrayList<Integer> al=new ArrayList<Integer>();
                al.add(Integer.parseInt(arr[1]));
                ht.put(arr[0],al);
            }
        }
        HashSet<String> hs=new HashSet<String>(ht.keySet());
        for(String x : hs)
             Collections.sort(ht.get(x));
        int q=sc.nextInt();
        //sc.readLine();
        StringBuilder output=new StringBuilder();
        for(int i=0;i<q;i++)
        {
            String[] arr=sc.readLine().split(" ");
            output.append(ht.get(arr[0]).get(Integer.parseInt(arr[1])-1));
            if(i<q-1)
                output.append("\n");
        }
        System.out.println(output);
    }
}