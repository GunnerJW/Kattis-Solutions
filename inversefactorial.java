/*
Java solution for the problem Inverse Factorial (https://open.kattis.com/problems/inversefactorial)
Execution time: 0.09 s
Submitted on 2017-03-29 03:16:01
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
 
        public String readLine() throws IOException
        {
            byte[] buf = new byte[1000000]; // line length
            int cnt = 0, c;
            while ((c = read()) != -1)
            {
                if (c == '\n')
                    break;
                buf[cnt++] = (byte) c;
            }
            return new String(buf, 0, cnt);
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
        String s=sc.readLine();
        int length=s.length();
        if(length<=10)
        {
            long fact=Long.parseLong(s),tmp=1;
            int i=2;
            while(tmp!=fact)
            {
                tmp*=i;
                i++;
            }
            System.out.println(i-1);
        }
        else
        {
            int i=2;
            double currLength=1.0;
            while(true)
            {
                currLength+=Math.log10(i);
                if(Math.floor(currLength)==length)
                {
                    System.out.println(i);
                    break;
                }
                i++;
            }
        }
      }
}
