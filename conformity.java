/*
Java solution for the problem Conformity (https://open.kattis.com/problems/conformity)
Execution time: 0.38 s
Submitted on 2017-09-04 01:06:08
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;


class Main {
	
    public static void main(String[] args) throws IOException{
    	Scanner sc=new Scanner(System.in);
    	int frosh=sc.nextInt();
    	HashMap<String,Integer> freq=new HashMap<String,Integer>(frosh);
    	for(int i=0;i<frosh;i++)
    	{
    		TreeSet<Integer> ts=new TreeSet<Integer>();
    		for(int j=0;j<5;j++)
    			ts.add(sc.nextInt());
    		StringBuilder sb=new StringBuilder();
    		for(int tmp : ts)
    			sb.append(String.valueOf(tmp));
    		String tmp=sb.toString();
    		if(freq.containsKey(tmp))
    			freq.put(tmp, freq.get(tmp)+1);
    		else
    			freq.put(tmp, 1);
    	}
    	ArrayList<Integer> al=new ArrayList<Integer>(freq.values());
    	Collections.sort(al);
    	int size=al.size();
    	int sum=al.get(size-1);
    	for(int i=size-2;i>=0;i--)
    	{
    		if(al.get(i)!=al.get(size-1))
    			break;
    		sum+=al.get(i);
    	}
    	System.out.println(sum);
    }
}