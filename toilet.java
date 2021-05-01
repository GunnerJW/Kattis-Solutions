/*
Java solution for the problem Toilet Seat (https://open.kattis.com/problems/toilet)
Execution time: 0.07 s
Submitted on 2018-04-23 10:56:16
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

public class Solution
{
    static int numberOfAdjustments(int policy,String sequence)
    {
        int length=sequence.length();
        char currentState=sequence.charAt(0);
        int adjustments=0;
        for(int i=1;i<length;i++)
        {
            char c=sequence.charAt(i);
            if(c!=currentState)
            {
                adjustments++;
                currentState=c;
            }
            if(policy<2)
            {
                if(c==policyMapping.get(policy))
                    adjustments++;
                currentState=policyMapping.get(1-policy);
            }
        }
        return adjustments;
    }
    static HashMap<Integer,Character> policyMapping;
	public static void main(String args[]) throws Exception
	{
		Scanner sc=new Scanner(System.in);
        String sequence=sc.nextLine();
        policyMapping=new HashMap<Integer,Character>(2);
        policyMapping.put(0,'D');
        policyMapping.put(1,'U');
        System.out.println(numberOfAdjustments(0,sequence));
        System.out.println(numberOfAdjustments(1,sequence));
        System.out.println(numberOfAdjustments(2,sequence));
    }
}
