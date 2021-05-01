/*
Java solution for the problem Islands in the Data Stream (https://open.kattis.com/problems/islands)
Execution time: 0.08 s
Submitted on 2017-04-22 17:54:10
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
        for(int i=0;i<n;i++)
        {
            int t=sc.nextInt();
            int[] arr=new int[12];
            for(int j=0;j<12;j++)
                arr[j]=sc.nextInt();
            int window=1;
            int islands=0;
            while(window<=10)
            {
                lp:for(int j=1;j<=10-window+1;j++)
                {
                    for(int k=j;k<=j+window-1;k++)
                    {
                        if(arr[k]<=arr[j-1] || arr[k]<=arr[j+window])
                        {
                            continue lp;
                        }
                        if(k==j+window-1 && arr[k]>arr[j-1] && arr[k]>arr[j+window])
                            islands++;
                    }
                }
                window++;
            }
            System.out.println(t+" "+islands);
        }
   }
}