/*
Java solution for the problem Union-Find (https://open.kattis.com/problems/unionfind)
Execution time: 0.76 s
Submitted on 2017-09-10 01:28:31
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;
import java.io.*;

public class Solution {
    
    static class Ufds
    {
	private int[] parent,rank;
	public Ufds(int n)
	{
		parent=new int[n];
		rank=new int[n];
		for(int i=0;i<n;i++)
		    parent[i]=i;
	}
	public int find(int x)//handle x>=n case
	{
		int tmp=x;
		while(tmp!=parent[tmp])
			tmp=parent[tmp];
		return tmp;
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
			}
			else if(rank[pa]>rank[pb])
				parent[pb]=pa;
			else
				parent[pa]=pb;
		}
	}
    }
    
    public static void main(String[] args) throws IOException{
        BufferedReader bf=new BufferedReader(new InputStreamReader(System.in));
        String s=bf.readLine();
        int spacei=s.indexOf(" ");
        int n=Integer.parseInt(s.substring(0,spacei));
        int m=Integer.parseInt(s.substring(spacei+1));
        Ufds uf=new Ufds(n);
        StringBuilder sb=new StringBuilder();
        for(int i=0;i<m;i++)
        {
            if(bf.read()==63)
            {
                bf.read();
                s=bf.readLine();
                spacei=s.indexOf(" ");
                int a=Integer.parseInt(s.substring(0,spacei));
                int b=Integer.parseInt(s.substring(spacei+1));
                if(uf.find(a)==uf.find(b))
                    sb.append("yes\n");
                else
                    sb.append("no\n");
            }
            else
            {
                bf.read();
                s=bf.readLine();
                spacei=s.indexOf(" ");
                int a=Integer.parseInt(s.substring(0,spacei));
                int b=Integer.parseInt(s.substring(spacei+1));
                uf.unite(a,b);
            }
        }
        System.out.print(sb.toString());
   }
}