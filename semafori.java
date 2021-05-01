/*
Java solution for the problem Semafori (https://open.kattis.com/problems/semafori)
Execution time: 0.05 s
Submitted on 2017-04-12 18:38:12
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
        int lights=sc.nextInt(),l=sc.nextInt();
        int time=0;
        int laststop=0;
        int d,r,g;
        int diff;
        for(int i=0;i<lights;i++)
        {
            d=sc.nextInt();
            r=sc.nextInt();
            g=sc.nextInt();
            time+=d-laststop;
            laststop=d;
            diff=r-time%(r+g);
            if(diff>0)
                time+=diff;
        }
        time+=l-laststop;
        System.out.println(time);
    }
}
