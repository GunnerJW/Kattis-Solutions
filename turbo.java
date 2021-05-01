/*
Java solution for the problem Turbo (https://open.kattis.com/problems/turbo)
Execution time: 0.85 s
Submitted on 2017-10-01 02:47:12
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static class FenwickTree
    {
	public int[] arr;
	public FenwickTree(int n)
	{
		arr=new int[n+1];
	}
	private static int LSOne(int i)
	{
		return (i&(-i));
	}
	public int query(int i)//returns sum of [1,i]
	{
		int sum=0;
		for(;i>0;i-=LSOne(i))
			sum+=arr[i];
		return sum;
	}
	public int query(int a,int b)
	{
		return this.query(b) - ((a==1)?0:this.query(a-1));
	}
	public void adjust(int k,int offset)
	{
		for(;k<arr.length;k+=LSOne(k))
			arr[k]+=offset;
	}
}
    final static int MAX=100000;

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
        int n=sc.getInt();
        FenwickTree ft=new FenwickTree(3*n);
        int[] pos=new int[n+1];
        for(int i=n+1;i<=2*n;i++)
        {
            int x=sc.getInt();
            ft.adjust(i,1);
            pos[x]=i;
        }
        int left=1;
        int right=3*n;
        for(int i=1;i<=n;i++)
        {
            if(i%2==1)
            {
                int target=i/2+1;
                //System.out.println(target);
                int loc=pos[target];
                System.out.println(ft.query(loc)-ft.query(left)-1);
                ft.adjust(loc,-1);
                ft.adjust(left,1);
                pos[target]=left++;
            }
            else
            {
                int target=n-i/2+1;
                //System.out.println(target);
                int loc=pos[target];
                System.out.println(ft.query(right)-ft.query(loc));//the 3*n is questionable
                ft.adjust(loc,-1);
                ft.adjust(right,1);
                pos[target]=right--;
            }
        }
    }
}