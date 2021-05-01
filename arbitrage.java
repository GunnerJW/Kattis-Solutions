/*
Java solution for the problem Arbitrage? (https://open.kattis.com/problems/arbitrage)
Execution time: 0.64 s
Submitted on 2017-09-20 21:03:09
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

public class Solution {
   
    static class GraphWeightedMatrix
{
	int vertices;
	double[][] adjMatrix;
	double[][] apspMatrix;
	boolean[] cycleDetector;
	int[][] p;
	public GraphWeightedMatrix(int v)
	{
		vertices=v;
		p=new int[vertices][vertices];
		cycleDetector=new boolean[vertices];
		apspMatrix=new double[vertices][vertices]; 
		adjMatrix=new double[vertices][vertices];
		for(int i=0;i<vertices;i++)
			for(int j=0;j<v;j++)
			{
				if(i!=j)
					adjMatrix[i][j]=1000000000;
				p[i][j]=i;
			}
	}
	public void add(int i,int j,double w)
	{
		adjMatrix[i][j]=w;
	}
	public void floydW()
	{
		for(int i=0;i<vertices;i++)
			apspMatrix[i]=Arrays.copyOf(adjMatrix[i], vertices);
		for (int k=0;k<vertices;k++)
			for (int i=0;i<vertices;i++)
				for (int j=0;j<vertices;j++)
					if (apspMatrix[i][k] + apspMatrix[k][j] < apspMatrix[i][j])
					{
                        if(i==j)
                        {
                            System.out.println("Arbitrage");
                            return;
                        }
						apspMatrix[i][j] = apspMatrix[i][k] + apspMatrix[k][j];
						p[i][j] = p[k][j];
					}
		System.out.println("Ok");
        return;
	}
}


    public static void main(String args[])
    {
        Scanner sc=new Scanner(System.in);
        while(true)
        {
            int v=sc.nextInt();
            if(v==0)
                break;
            int vId=0;
            HashMap<String,Integer> hm=new HashMap<String,Integer>(v);
            for(int i=0;i<v;i++)
                hm.put(sc.next(),vId++);
            int e=sc.nextInt();
            GraphWeightedMatrix g=new GraphWeightedMatrix(v);
            for(int i=0;i<e;i++)
            {
                int src=hm.get(sc.next());
                int dst=hm.get(sc.next());
                String[] arr=sc.next().split(":");
                double rate=1.0*Integer.parseInt(arr[0])/Integer.parseInt(arr[1]);
                g.add(src,dst,Math.log(rate));
            }
            g.floydW();
        }
    }
}
 