/*
Java solution for the problem Farey Sequence Length (https://open.kattis.com/problems/farey)
Execution time: 0.17 s
Submitted on 2017-08-29 02:56:15
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
 
        public Reader(String file_name) throws IOException
        {
            din = new DataInputStream(new FileInputStream(file_name));
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
 
        public double nextDouble() throws IOException
        {
            double ret = 0, div = 1;
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
 
            if (c == '.')
            {
                while ((c = read()) >= '0' && c <= '9')
                {
                    ret += (c - '0') / (div *= 10);
                }
            }
 
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
    static ArrayList<Integer> primes=new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97));
    public static int eulerPhi(int n,ArrayList<Integer> primes)
	{
		int phi=1;
		int i=0,tmp=n;
		int pf=primes.get(i);
		int exp;
		while(pf*pf<=tmp)
		{
			exp=0;
			while(tmp%pf==0)
			{
				tmp/=pf;
				exp++;
				if(exp==1)
					phi*=pf-1;
				else
					phi*=pf;
			}
			i++;
			if(i>=primes.size())
				break;
			pf=primes.get(i);
		}
		if(tmp!=1)
		{
			phi*=tmp-1;
		}
		return phi;
	}
    public static void main(String[] args) throws IOException{
        int[] x=new int[10001];
    	x[0]=0;
    	x[1]=2;
    	for(int i=2;i<=10000;i++)
    		x[i]=x[i-1]+eulerPhi(i, primes);
        Reader sc = new Reader();
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            int nCase=sc.nextInt();
            int N=sc.nextInt();
            System.out.println(nCase+" "+x[N]);
        }
    }
}