/*
Java solution for the problem Virtual Friends (https://open.kattis.com/problems/virtualfriends)
Execution time: 0.83 s
Submitted on 2017-04-04 02:22:13
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    static class Ufds
    {
	private int[] parent,rank,number;
	public Ufds(int n)
	{
		parent=new int[n];
		rank=new int[n];
		for(int i=0;i<n;i++)
			parent[i]=i;
        number=new int[n];
        Arrays.fill(number,1);
	}
	public int find(int x)//handle x>=n case
	{
		if(parent[x]==x)
			return x;
		return find(parent[x]);
	}
	public void unite(int a,int b) //must add path-compression
	{
		int pa=this.find(a),pb=this.find(b);
		if(pa!=pb)
		{
			if(rank[pa]==rank[pb])
			{
				parent[pa]=pb;
				rank[pb]++;
                number[pb]+=number[pa];
			}
			else if(rank[pa]>rank[pb])
            {
                parent[pb]=pa;
                number[pa]+=number[pb];
            }
			else
            {
                parent[pa]=pb;
                number[pb]+=number[pa];
            }
		}
	}
    public int getNumber(int x)
    {return number[find(x)];}
}

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt(),i,f,j,k;
        String s1,s2;
        for(i=0;i<t;i++)
        {
            f=sc.nextInt();
            Ufds uf=new Ufds(2*f);
            Hashtable<String,Integer> ht=new Hashtable<String,Integer>(2*f);
            k=0;
            for(j=0;j<f;j++)
            {
                s1=sc.next();
                s2=sc.next();
                if(!ht.containsKey(s1))
                {
                    ht.put(s1,k);
                    k++;
                }
                if(!ht.containsKey(s2))
                {
                    ht.put(s2,k);
                    k++;
                }
                uf.unite(ht.get(s1),ht.get(s2));
                System.out.println(uf.getNumber(ht.get(s1)));
            }
        }
    }
}