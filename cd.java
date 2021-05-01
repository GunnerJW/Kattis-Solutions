/*
Java solution for the problem CD (https://open.kattis.com/problems/cd)
Execution time: 1.24 s
Submitted on 2017-03-29 03:50:36
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
 
    }
    
    public static void main(String[] args) throws IOException{
        
        Reader sc=new Reader();
        int i,n=sc.nextInt(),m=sc.nextInt();
        int cd=0,occ,label;
        while(n!=0 && m!=0)
        {
            Hashtable<Integer,Integer> ht=new Hashtable<Integer,Integer>(m+n);
            for(i=0;i<n+m;i++)
            {
                label=sc.nextInt();
                if(ht.containsKey(label))
                    ht.put(label,ht.get(label)+1);
                else
                    ht.put(label,1);
            }
            HashSet<Integer> hs=new HashSet<Integer>(ht.keySet());
            for(int x : hs)
            {
                occ=ht.get(x);
                if(occ==2)
                    cd++;
            }
            System.out.println(cd);
            cd=0;
            n=sc.nextInt();
            m=sc.nextInt();
        }
    }
}