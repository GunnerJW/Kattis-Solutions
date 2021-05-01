/*
Java solution for the problem Counting Subsequences (Hard) (https://open.kattis.com/problems/subseqhard)
Execution time: 1.18 s
Submitted on 2018-05-09 23:12:28
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

class Main
{
	static class Reader
	{
		final private int BUFFER_SIZE=1<<16;
		private DataInputStream din;
		private byte[] buffer;
		private int bufferPointer,bytesRead;

		public Reader()
		{
			din=new DataInputStream(System.in);
			buffer=new byte[BUFFER_SIZE];
			bufferPointer=bytesRead=0;
		}

		public String readLine() throws IOException
		{
			byte[] buf=new byte[64]; // line length
			int cnt=0,c;
			while((c=read())!=-1)
			{
				if(c=='\n') break;
				buf[cnt++]=(byte)c;
			}
			return new String(buf,0,cnt);
		}

		public int nextInt() throws IOException
		{
			int ret=0;
			byte c=read();
			while(c<=' ')
				c=read();
			boolean neg=(c=='-');
			if(neg) c=read();
			do
			{
				ret=ret*10+c-'0';
			}
			while((c=read())>='0'&&c<='9');
			if(neg) return -ret;
			return ret;
		}

		public long nextLong() throws IOException
		{
			long ret=0;
			byte c=read();
			while(c<=' ')
				c=read();
			boolean neg=(c=='-');
			if(neg) c=read();
			do
			{
				ret=ret*10+c-'0';
			}
			while((c=read())>='0'&&c<='9');
			if(neg) return -ret;
			return ret;
		}

		public double nextDouble() throws IOException
		{
			double ret=0,div=1;
			byte c=read();
			while(c<=' ')
				c=read();
			boolean neg=(c=='-');
			if(neg) c=read();
			do
			{
				ret=ret*10+c-'0';
			}
			while((c=read())>='0'&&c<='9');
			if(c=='.')
			{
				while((c=read())>='0'&&c<='9')
				{
					ret+=(c-'0')/(div*=10);
				}
			}
			if(neg) return -ret;
			return ret;
		}

		private void fillBuffer() throws IOException
		{
			bytesRead=din.read(buffer,bufferPointer=0,BUFFER_SIZE);
			if(bytesRead==-1) buffer[0]=-1;
		}

		private byte read() throws IOException
		{
			if(bufferPointer==bytesRead) fillBuffer();
			return buffer[bufferPointer++];
		}

		public void close() throws IOException
		{
			if(din==null) return;
			din.close();
		}
	}

	public static void main(String[] args) throws IOException
	{
		Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        while(t-->0)
        {
            sc.nextLine();
            int n=sc.nextInt();
            long[] arr=new long[n];
            long[] prefix_sum=new long[n];
            for(int i=0;i<n;i++)
            {
                arr[i]=sc.nextLong();
                prefix_sum[i]=arr[i]+((i>0)?prefix_sum[i-1]:0);
            }
            HashMap<Long,Long> sum_f=new HashMap<Long,Long>(n);
            long res=0;
            if(arr[0]==47)
                res++;
            long sum=arr[0];
            sum_f.put(sum,1L);
            sum_f.put(0L,1L);	
            for(int i=1;i<n;i++)
            {
                long aux=prefix_sum[i]-47;
                if(sum_f.containsKey(aux))
                    res+=sum_f.get(aux);
                sum+=arr[i];
                if(sum_f.containsKey(sum))
                    sum_f.put(sum,sum_f.get(sum)+1);
                else
                    sum_f.put(sum,1L);
            }
            if(prefix_sum[n-1]==47)
                res++;
            System.out.println(res);
        }
	}
}