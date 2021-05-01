/*
Java solution for the problem Tour de France (https://open.kattis.com/problems/tourdefrance)
Execution time: 0.07 s
Submitted on 2017-04-13 15:21:05
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
        int f,r,i,j;
        f=sc.nextInt();
        while(f!=0)
        {
            r=sc.nextInt();
            int[] front=new int[f];
            int[] rear=new int[r];
            for(i=0;i<f;i++)
                front[i]=sc.nextInt();
            for(i=0;i<r;i++)
                rear[i]=sc.nextInt();
            double[] ratio=new double[r*f];
            for(i=0;i<r;i++)
            {
                for(j=0;j<f;j++)
                    ratio[f*i+j]=(double)rear[i]/(double)front[j];
            }
            Arrays.sort(ratio);
            double max=0,spread;
            for(i=1;i<r*f;i++)
            {
                spread=ratio[i]/ratio[i-1];
                max=(spread>max)?spread:max;
            }
            System.out.printf("%.2f",max);
            System.out.println("");
            f=sc.nextInt();
        }
    }
}