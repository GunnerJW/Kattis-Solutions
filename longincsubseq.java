/*
Java solution for the problem Longest Increasing Subsequence (https://open.kattis.com/problems/longincsubseq)
Execution time: 0.7 s
Submitted on 2017-10-14 14:53:46
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {
    private static int binarySearch(ArrayList<Integer> LIS,int[] a,int key)
	{
		int n=LIS.size();
		int low=0;
		int high=n-1;
		int mid;
		while(low<high)
		{
			mid=(low+high)/2;
			if(a[LIS.get(mid)]>key)
				high=mid;
			else if(a[LIS.get(mid)]<key)
				low=mid+1;
			else
				return mid;
		}
		return low;
	}
	public static int[] LIS2(int[] a)//O(nlogn)
	{
		int n=a.length;
		ArrayList<Integer> LIS=new ArrayList<Integer>(n);
		int[] parent=new int[n];
		int idx=0;
		LIS.add(0);
		parent[0]=-1;
		for(int i=1;i<n;i++)
		{
			if(a[i]>a[LIS.get(idx)])
			{
				LIS.add(i);
				parent[i]=LIS.get(idx);
				idx++;
			}
			else
			{
				int insertionPt=binarySearch(LIS,a,a[i]);
				if(insertionPt==0)
					parent[i]=-1;
				else
					parent[i]=LIS.get(insertionPt-1);
				LIS.set(insertionPt,i);
			}
		}
		int[] res=new int[idx+1];
		int curr=idx;
		int x=LIS.get(idx);
		while(x!=-1)
		{
			res[curr--]=x;
			x=parent[x];
		}
		return res;
	}
    static class Kattio extends PrintWriter {
    public Kattio(InputStream i) {
        super(new BufferedOutputStream(System.out));
        r = new BufferedReader(new InputStreamReader(i));
    }
    public Kattio(InputStream i, OutputStream o) {
        super(new BufferedOutputStream(o));
        r = new BufferedReader(new InputStreamReader(i));
    }

    public boolean hasMoreTokens() {
        return peekToken() != null;
    }

    public int getInt() {
        return Integer.parseInt(nextToken());
    }

    public double getDouble() {
        return Double.parseDouble(nextToken());
    }

    public long getLong() {
        return Long.parseLong(nextToken());
    }

    public String getWord() {
        return nextToken();
    }



    private BufferedReader r;
    private String line;
    private StringTokenizer st;
    private String token;

    private String peekToken() {
        if (token == null)
            try {
                while (st == null || !st.hasMoreTokens()) {
                    line = r.readLine();
                    if (line == null) return null;
                    st = new StringTokenizer(line);
                }
                token = st.nextToken();
            } catch (IOException e) { }
        return token;
    }

    private String nextToken() {
        String ans = peekToken();
        token = null;
        return ans;
    }
}
    public static void main(String[] args) throws IOException{
        Kattio sc=new Kattio(System.in);
        while(sc.hasMoreTokens())
        {
            int n=sc.getInt();
            int[] arr=new int[n];
            for(int i=0;i<n;i++)
                arr[i]=sc.getInt();
            int[] parent=LIS2(arr);
            System.out.println(parent.length);
            for(int tmp : parent)
                System.out.print(tmp+" ");
            System.out.println();
        }
    }
}