/*
Java solution for the problem Trik (https://open.kattis.com/problems/trik)
Execution time: 0.07 s
Submitted on 2018-07-14 00:46:06
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;
import java.lang.*;

class Ideone
{
	public static void main (String[] args)
	{
		Scanner sc=new Scanner(System.in);
		String sequence=sc.nextLine();
		int position = 0; // 0 for left 1 for middle and 2 for right
		for(int i=0;i<sequence.length();i++)
		{
			char c=sequence.charAt(i);
			if(c=='A' && position!=2)
			{
				position = 1-position;
			}
			else if(c=='B' && position!=0)
			{
				position = -position+3;
			}
			else if(c=='C' && position!=1)
			{
				position = -position+2;
			}
		}
		System.out.println(1+position);
	}
}