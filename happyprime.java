/*
Java solution for the problem Happy Happy Prime Prime (https://open.kattis.com/problems/happyprime)
Execution time: 0.16 s
Submitted on 2017-04-13 01:31:04
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
    static class Maths
    {
	static boolean isPrime(int n,ArrayList<Integer> primes)
	{
		int i=0;
		while(i<primes.size() && primes.get(i)*primes.get(i)<=n)
		{
			if(n%primes.get(i)==0)
				return false;
			i++;
		}
		return true;
	}
	static int gcd(int a,int b)
	{
		return b==0?a:gcd(b,a%b);
	}
	static int lcm(int a,int b)
	{
		return a*b/gcd(a,b);
	}
	public static HashMap<Integer,Integer> primeFctPow(int n,ArrayList<Integer> primes)//handle n<=1
	{
		int m=(int)Math.sqrt(n);
		double d=(m/Math.log(m))*(1+1.2762/Math.log(m));
		HashMap<Integer,Integer> hm=new	HashMap<Integer,Integer>((int)d);
		int i=0,tmp=n;
		int pf=primes.get(i);
		while(pf*pf<=tmp)
		{
			while(tmp%pf==0)
			{
				tmp/=pf;
				if(hm.containsKey(pf))
					hm.put(pf, hm.get(pf)+1);
				else
					hm.put(pf, 1);
			}
			i++;
			if(i>=primes.size())
				break;
			pf=primes.get(i);
		}
		if(tmp!=1)
		{
			if(hm.containsKey(tmp))
				hm.put(tmp, hm.get(tmp)+1);
			else
				hm.put(tmp, 1);
		}
		return hm;
	}
	public static ArrayList<Integer> primeFct(int n,ArrayList<Integer> primes)//handle n<=1
	{
		int m=(int)Math.sqrt(n);
		double d=(m/Math.log(m))*(1+1.2762/Math.log(m));
		ArrayList<Integer> al=new ArrayList<Integer>((int)d);
		int i=0,tmp=n;
		int pf=primes.get(i);
		while(pf*pf<=tmp)
		{
			while(tmp%pf==0)
			{
				tmp/=pf;
				al.add(pf);
			}
			i++;
			if(i>=primes.size())
				break;
			pf=primes.get(i);
		}
		if(tmp!=1)
		{
			al.add(tmp);
		}
		return al;
	}
	public static ArrayList<Integer> primeSieve(int n)
	{
		ArrayList<Integer> primes=new ArrayList<Integer>();
		boolean[] crossed=new boolean[n+1];
		crossed[0]=true;
		crossed[1]=true;
		int m=0,i;
		while(m!=n)
		{
			for(i=2;i<n+1;i++)
			{
				if(crossed[i]==false)
				{
					m=i;
					primes.add(m);
					break;
				}
			}
			if(i==n+1)
				break;
			for(i=m;i<n+1;i+=m)
			{
				crossed[i]=true;
			}
		}
		return primes;
	}
}
    public static void main(String[] args) throws IOException{
        Reader sc=new Reader();
        ArrayList<Integer> primes=new ArrayList<Integer>(Arrays.asList(2, 3, 5, 7, 11, 13, 17, 19, 23, 29, 31, 37, 41, 43, 47, 53, 59, 61, 67, 71, 73, 79, 83, 89, 97
));
        int q=sc.nextInt();
        int c,n,sum=0,tmp;
        for(int i=0;i<q;i++)
        {
            c=sc.nextInt();
            n=sc.nextInt();
            if(n!=1 && Maths.isPrime(n,primes))
            {
                tmp=n;
                while(tmp!=1 && tmp!=4)
                {
                    while(tmp!=0)
                    {
                        sum+=(tmp%10)*(tmp%10);
                        tmp/=10;
                    }
                    tmp=sum;
                    //System.out.println(tmp);
                    sum=0;
                }
                if(tmp==1)
                    System.out.println(c+" "+n+" YES");
                else if(tmp==4)
                    System.out.println(c+" "+n+" NO");
            }
            else
                System.out.println(c+" "+n+" NO");
        }
    }
}