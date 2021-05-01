/*
Java solution for the problem Ladder (https://open.kattis.com/problems/ladder)
Execution time: 0.07 s
Submitted on 2018-04-23 10:59:17
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

public class Solution
{
	public static void main(String args[]) throws Exception
	{
		Scanner sc=new Scanner(System.in);
        int h=sc.nextInt();
        int v=sc.nextInt();
        System.out.println((int)Math.ceil(h/Math.sin(v*Math.PI/180)));
    }
}
