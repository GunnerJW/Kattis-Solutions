/*
Java solution for the problem Integer Lists (https://open.kattis.com/problems/integerlists)
Execution time: 0.39 s
Submitted on 2018-04-30 19:42:12
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
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
            buffer = new byte[BUFFER_SIZE];
            bufferPointer = bytesRead = 0;
        }
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[410000]; // line length
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
            String program=sc.readLine();
            int l=program.length();
            int n=sc.nextInt();
            String list=sc.readLine();
            if(n==0)
            {
                if(program.indexOf("D")!=-1)
                {
                    System.out.println("error");
                }
                else
                    System.out.println("[]");
            }
            else
            {
                ArrayDeque<String> q=new ArrayDeque<String>(Arrays.asList(list.substring(1,list.length()-1).split(",")));
                int pointer=0;
                boolean error=false;
                for(int j=0;j<l;j++)
                {
                    if(program.charAt(j)=='R')
                        pointer=1-pointer;
                    else
                    {
                        if(q.isEmpty())
                        {
                            error=true;
                            break;
                        }
                        else
                        {
                            if(pointer==0)
                                q.pollFirst();
                            else
                                q.pollLast();
                        }
                    }
                }
                if(error)
                    System.out.println("error");
                else
                {
                    StringBuilder output=new StringBuilder("[");
                    while(!q.isEmpty())
                    {
                        String tmp=(pointer==0)?q.pollFirst():q.pollLast();
                        output.append(tmp);
                        if(!q.isEmpty())
                            output.append(",");
                    }
                    output.append("]");
                    System.out.println(output);
                }      
            }
        }
    }
}