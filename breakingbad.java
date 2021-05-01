/*
Java solution for the problem Breaking Bad (https://open.kattis.com/problems/breakingbad)
Execution time: 0.61 s
Submitted on 2017-09-23 16:15:36
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

public class Solution {
   
    static class Graph
    {
	private ArrayList<ArrayList<Integer>> adjList;
	public int[] color;
	private ArrayDeque<Integer> q;
	public Graph(int n)
	{
		color=new int[n];
        Arrays.fill(color,10);
		q=new ArrayDeque<Integer>(n);
		adjList=new ArrayList<ArrayList<Integer>>(n);
		for(int i=0;i<n;i++)
            adjList.add(new ArrayList<Integer>());
	}
	public void add(int i,int j)
	{
        adjList.get(i).add(j);
        adjList.get(j).add(i);
        return;
    }
	public boolean bipartite_coloring()
	{
		//this.reset();
        int n=color.length;
        int general=0;
        for(int x=0;x<n;x++)
        {
            if(color[x]==10)
            {
                q.add(x);
                color[x]=general;
                general=1-general;
                while(!q.isEmpty())
                {
                    int v=q.remove();
                    for(int i=0;i<adjList.get(v).size();i++)
                    {
                        int z=adjList.get(v).get(i);
                        if(color[z]==10)
                        {
                            q.add(z);
                            color[z]=1-color[v];
                        }
                        else if(color[z]==color[v])
                            return false;
                    }
                }
            }
        }
        return true;
		/*q.add(u);
		color[u]=0;
		while(!q.isEmpty())
		{
			int x=q.remove();
			for(int i=0;i<adjList.get(x).size();i++)
			{
				int z=adjList.get(x).get(i);
				if(color[z]==10)
				{
					q.add(z);
					color[z]=1-color[x];
				}
                else if()
			}
		}
        return;*/
	}
}


    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        Graph g=new Graph(v);
        int vId=0;
        HashMap<String,Integer> hm=new HashMap<String,Integer>(v);
        HashMap<Integer,String> reverse=new HashMap<Integer,String>(v);
        for(int i=0;i<v;i++)
        {
            String s=sc.next();
            hm.put(s,vId);
            reverse.put(vId,s);
            vId++;
        }
        int e=sc.nextInt();
        for(int i=0;i<e;i++)
            g.add(hm.get(sc.next()),hm.get(sc.next()));
        boolean b=g.bipartite_coloring();
        if(b==false)
            System.out.println("impossible");
        else
        {
            StringBuilder first=new StringBuilder();
            StringBuilder second=new StringBuilder();
            for(int i=0;i<v;i++)
            {
                if(g.color[i]==0)
                    first.append(reverse.get(i)+" ");
                else
                    second.append(reverse.get(i)+" ");
            }
            System.out.println(first.toString());
            System.out.println(second.toString());
        }               
    }
}
 