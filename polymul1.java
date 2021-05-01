/*
Java solution for the problem Polynomial Multiplication 1 (https://open.kattis.com/problems/polymul1)
Execution time: 0.22 s
Submitted on 2017-04-12 22:37:41
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
        int t=sc.nextInt();
        int i,dp,dq,c=0;
        for(i=0;i<t;i++)
        {
            dp=sc.nextInt();
            int[] p=new int[dp+1];
            for(int j=0;j<=dp;j++)
                p[j]=sc.nextInt();
            dq=sc.nextInt();
            int[] q=new int[dq+1];
            for(int j=0;j<=dq;j++)
                q[j]=sc.nextInt();
            System.out.println(dq+dp);
            for(int j=0;j<=dp+dq;j++)
            {
                for(int k=0;k<=j;k++)
                {
                    if(k<=dp && j-k<=dq)
                        c+=p[k]*q[j-k];
                }
                System.out.print(c+" ");
                c=0;
            }
            System.out.println("");
        }
    }
}