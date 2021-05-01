/*
Java solution for the problem Stacking Cups (https://open.kattis.com/problems/cups)
Execution time: 0.08 s
Submitted on 2018-04-23 10:58:28
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

public class Solution
{
    static boolean isNumber(String s)
    {
        try
        {
            int x=Integer.parseInt(s);
        }
        catch(NumberFormatException e)
        {
            return false;
        }
        return true;
    }
	public static void main(String args[]) throws Exception
	{
		Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        TreeMap<Integer,String> tm=new TreeMap<Integer,String>();
        for(int i=0;i<n;i++)
        {
            String s1=sc.next();
            String s2=sc.next();
            if(isNumber(s1))
            {
                tm.put(Integer.parseInt(s1)/2,s2);
            }
            else if(isNumber(s2))
            {
                tm.put(Integer.parseInt(s2),s1);
            }
        }
        for(String color:tm.values())
            System.out.println(color);
    }
}
