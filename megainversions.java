/*
Java solution for the problem Mega Inversions (https://open.kattis.com/problems/megainversions)
Execution time: 0.5 s
Submitted on 2018-04-22 17:02:21
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

public class Solution
{
    static class FenwickTree2
{
	private int n;
	private int[] ft1;
	private int[] ft2;

	public FenwickTree2(int n)
	{
		this.n=n+1;
		ft1=new int[n+1];
		ft2=new int[n+1];
	}

	private static int LSOne(int i)
	{
		return (i&(-i));
	}

	private void increment(int[] ft,int k,int offset)
	{
		for(;k<n;k+=LSOne(k))
			ft[k]+=offset;
	}

	public void incrementRange(int i,int j,int offset)
	{
		increment(ft1,i,offset);
		increment(ft1,j+1,-offset);
		increment(ft2,i,offset*(i-1));
		increment(ft2,j+1,-offset*j);
	}

	private int query(int[] ft,int i)
	{
		int sum=0;
		for(;i>0;i-=LSOne(i))
			sum+=ft[i];
		return sum;
	}

	public int query(int i)
	{
		return query(ft1,i)*i-query(ft2,i);
	}

	public int query(int i,int j)
	{
        if(j==0 || i==n)
            return 0;
		return query(j)-query(i-1);
	}
}
	public static void main(String args[]) throws Exception
	{
		Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int[] arr=new int[n];
        FenwickTree2 rl=new FenwickTree2(n);
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.nextInt();
            rl.incrementRange(arr[i],arr[i],1);
        }
        FenwickTree2 lr=new FenwickTree2(n);
        long res=0;
        for(int i=0;i<n;i++)
        {
            lr.incrementRange(arr[i],arr[i],1);
            res+=(long)lr.query(arr[i]+1,n)*rl.query(1,arr[i]-1);
            rl.incrementRange(arr[i],arr[i],-1);
        }
        System.out.println(res);
    }
}
