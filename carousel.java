/*
Java solution for the problem Carousel Rides (https://open.kattis.com/problems/carousel)
Execution time: 0.06 s
Submitted on 2017-04-21 15:12:40
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
        int m=sc.nextInt();
        while(n!=0 || m!=0)
        {
            double maxRatio=0;
            int tick=0,pr=0;
            for(int i=0;i<n;i++)
            {
                int t=sc.nextInt();
                int p=sc.nextInt();
                if(t<=m)
                {
                    double r=(double)t/(double)p;
                    if(r>maxRatio)
                    {
                        maxRatio=r;
                        tick=t;
                        pr=p;
                    }
                    else if(r==maxRatio)
                    {
                        if(t>tick)
                        {
                            tick=t;
                            pr=p;
                        }
                    }
                }
            }
            if(tick==0 && pr==0)
                System.out.println("No suitable tickets offered");
            else
                System.out.println("Buy "+tick+" tickets for $"+pr);
            n=sc.nextInt();
            m=sc.nextInt();
        }
    }
}
