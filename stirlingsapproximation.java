/*
Java solution for the problem Stirling's Approximation (https://open.kattis.com/problems/stirlingsapproximation)
Execution time: 0.07 s
Submitted on 2017-04-16 04:25:40
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
        Reader sc = new Reader();
        double[] arr=new double[100001];
		arr[0]=0;
		arr[1]=0;
		for(int i=2;i<=100000;i++)
		{
			arr[i]=arr[i-1]+Math.log(i);
		}
        int n=sc.nextInt();
        while(n!=0)
        {
            double s=0.5*Math.log(2*n*Math.PI)+n*(Math.log(n)-1);
            double app=arr[n]-s;
            System.out.println(Math.exp(app));
            n=sc.nextInt();
        }
    }
}
