/*
Java solution for the problem A Rational Sequence 2 (https://open.kattis.com/problems/rationalsequence2)
Execution time: 0.11 s
Submitted on 2017-04-07 01:07:38
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
        int n=sc.nextInt();
        int i=0;
        int p,q;
        while(i!=n)
        {
            i=sc.nextInt();
            String[] arr=sc.readLine().split("/");
            p=Integer.parseInt(arr[0]);
            q=Integer.parseInt(arr[1]);
            ArrayList<Integer> parity=new ArrayList<Integer>(32);
            int rank=1;
            while(p!=1 || q!=1)
            {
                if(p>q)
                {
                    parity.add(1);
                    p-=q;
                }
                else
                {
                    parity.add(0);
                    q-=p;
                }
            }
            for(int j=parity.size()-1;j>=0;j--)
                rank=2*rank+parity.get(j);
            System.out.println(i+" "+rank);
            rank=1;
        }
    }
}
