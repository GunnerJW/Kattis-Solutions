/*
Java solution for the problem String Matching (https://open.kattis.com/problems/stringmatching)
Execution time: 0.64 s
Submitted on 2017-09-09 18:19:51
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    static char[] T;
	static char[] P;
	static int[] b;//length of b is length of P + 1
	static int n;//length of T
	static int m;//length of P
	static void kmpPreprocess()
	{ 
		int i=0,j=-1; 
		b[0]=-1;
		while(i<m)
		{
			while (j >= 0 && P[i] != P[j])
				j = b[j];
			i++;
			j++;
			b[i]=j;
		} 
	}
	static void kmpSearch()
	{
		int i=0,j=0;
		while(i<n)
		{
			while (j >= 0 && T[i] != P[j])
				j = b[j];
			i++; 
			j++;
			if(j==m)
			{
				System.out.print((i-j)+" ");
				j = b[j];
			}
		}
        System.out.println("");
	}
    
    
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        while(sc.hasNext())
        {
            P=sc.nextLine().toCharArray();
            m=P.length;
            b=new int[m+1];
            T=sc.nextLine().toCharArray();
            n=T.length;
            kmpPreprocess();
            //System.out.println(Arrays.toString(T));
            kmpSearch();
        }
    }
}

