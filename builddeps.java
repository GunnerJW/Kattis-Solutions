/*
Java solution for the problem Build Dependencies (https://open.kattis.com/problems/builddeps)
Execution time: 2.0 s
Submitted on 2017-09-25 01:51:15
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static class Graph
    {
    private ArrayList<ArrayList<Integer>> adjList;
    private boolean[] visited;
    public ArrayDeque<String> q;
    public Graph(int n)
    {
        visited=new boolean[n];
        q=new ArrayDeque<String>(n);
        adjList=new ArrayList<ArrayList<Integer>>(n);
        for(int i=0;i<n;i++)
            adjList.add(new ArrayList<Integer>());
    }
    public void add(int i,int j)
    {
        adjList.get(i).add(j);
        return;
    }
    public void dfs(int u)
    {
        if(visited[u])
            return;
        visited[u]=true;
        for(int i=0;i<adjList.get(u).size();i++)
        {
            this.dfs(adjList.get(u).get(i));
        }
        q.addFirst(reverse.get(u));
        return;
    }
    public void reset()
    {
        visited=new boolean[visited.length];
    }
    public int reachable()
    {
        for(boolean b : visited)
            if(b==false)
                return 0;
        return 1;
    }
}
    static HashMap<Integer,String> reverse;
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int v=sc.nextInt();
        sc.nextLine();
        Graph g=new Graph(v);
        int verticeId=0;
        HashMap<String,Integer> hm=new HashMap<String,Integer>(v);
        reverse=new HashMap<Integer,String>(v);
        for(int i=0;i<v;i++)
        {
            String[] tmp=sc.nextLine().split(" ");
            //String s=tmp[0].substring(0,tmp[0].length()-1);
            //tmp[0]=s;
            tmp[0]=tmp[0].substring(0,tmp[0].length()-1);
            for(String s : tmp)
                if(!hm.containsKey(s))
                {
                    hm.put(s,verticeId);
                    reverse.put(verticeId,s);
                    verticeId++;
                }
            int length=tmp.length;
            for(int j=1;j<length;j++)
                g.add(hm.get(tmp[j]),hm.get(tmp[0]));
            //System.out.println(Arrays.toString(tmp));
        }
        String s=sc.next();
        g.dfs(hm.get(s));
        int size=g.q.size();
        for(int i=0;i<size;i++)
            System.out.println(g.q.poll());
        //g.bfs(hm.get(s),reverse);
    }
}
