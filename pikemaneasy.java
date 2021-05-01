/*
Java solution for the problem A Vicious Pikeman (Easy) (https://open.kattis.com/problems/pikemaneasy)
Execution time: 0.06 s
Submitted on 2017-05-04 19:02:05
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
    public static void main(String[] args) throws IOException{
        Reader sc=new Reader();
        int i,n=sc.nextInt(),dur=sc.nextInt();
        long a=sc.nextLong(),b=sc.nextLong(),c=sc.nextLong();
        long[] t=new long[n];
        t[0]=sc.nextLong();
        for(i=1;i<n;i++)
        {
            t[i]=(a*t[i-1]+b)%c+1;
        }
        Arrays.sort(t);
        //System.out.println(Arrays.toString(t));
        i=0;
        long penalty=0;
        int sum=0;
        while(i<n && sum+t[i]<=dur)
        {
            sum+=t[i];
            penalty=(penalty+sum)%1000000007;
            i++;
        }
        System.out.println(i+" "+penalty);
    }
}