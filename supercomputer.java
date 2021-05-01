/*
Java solution for the problem Supercomputer (https://open.kattis.com/problems/supercomputer)
Execution time: 0.74 s
Submitted on 2017-09-27 23:18:33
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static class SegmentTreeSum
    {
	public int[] st;
	private int[] arr;
	private int n;
	private void build(int p,int L,int R)
	{
		if(L==R)
		{
			st[p]=arr[L];
			return;
		}
		build(2*p,L,(L+R)/2);
		build(2*p+1,(L+R)/2+1,R);
		st[p]=st[2*p]+st[2*p+1];
	}
	private int query(int p,int L,int R,int i,int j)
	{
		if (i>R || j<L)
			return 0;
		if (L>=i && R<=j) 
			return st[p];
		int p1=query(2*p,L,(L+R)/2,i,j);
		int p2=query(2*p+1,(L+R)/2+1,R,i,j);
		/*if(p1==-1)
			return p2;
		if(p2==-1)
			return p1;*/
		return p1+p2;
	}
	private void update(int p,int L,int R,int i)
	{
		if(L==R)
		{
			if(L==i)
				st[p]=arr[i];
			return;
		}
		if(i>=L && i<=R)
		{
			update(2*p,L,(L+R)/2,i);
			update(2*p+1,(L+R)/2+1,R,i);
			st[p]=st[2*p]+st[2*p+1];
		}
		return;
	}
	public SegmentTreeSum(int[] a)
	{
		this.n=a.length;
		this.arr=Arrays.copyOf(a,n);
		this.st=new int[4*n];
		build(1,0,n-1);
	}
	public int query(int i,int j)
	{
		return query(1,0,n-1,i,j);
	}
	public void update(int i)
	{
		arr[i]=1-arr[i];
		update(1,0,n-1,i);
	}
}

    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        int q=sc.nextInt();
        SegmentTreeSum sts=new SegmentTreeSum(new int[n]);
        StringBuilder output=new StringBuilder();
        for(int i=0;i<q;i++)
        {
            String query=sc.next();
            if(query.equals("F"))
            {
                sts.update(sc.nextInt()-1);
            }
            else
            {
                int L=sc.nextInt()-1;
                int R=sc.nextInt()-1;
                output.append(sts.query(L,R));
                output.append("\n");
            }
        }
        System.out.println(output.deleteCharAt(output.length()-1).toString());
    }
}