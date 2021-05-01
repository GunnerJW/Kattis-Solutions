/*
Java solution for the problem Perket (https://open.kattis.com/problems/perket)
Execution time: 0.05 s
Submitted on 2017-04-22 17:55:40
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
        int[] s=new int[n];
        int[] b=new int[n];
        int x=(int)Math.pow(2,n)-1;
        for(int i=0;i<n;i++)
        {
            s[i]=sc.nextInt();
            b[i]=sc.nextInt();
        }
        int min=1000000005;
        for(int i=1;i<=x;i++)
        {
            String bin=Integer.toBinaryString(i);
            int l=bin.length();
            int sour=1,bit=0;
            for(int j=l-1;j>=0;j--)
            {
                if(Character.compare(bin.charAt(j),'1')==0)
                {
                    sour*=s[l-1-j];
                    bit+=b[l-1-j];
                }
            }
            int d=(int)Math.abs(sour-bit);
            if(d<min)
                min=d;
        }
        System.out.println(min);
   }
}