/*
Java solution for the problem Peculiar primes (https://open.kattis.com/problems/primes)
Execution time: 0.88 s
Submitted on 2017-08-23 13:39:55
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

public class Solution{
    static int[] primes;
    static int[] maxPowers;
    static int size;
    static int x;
    static int y;
    static TreeSet<Long> factors;
    static void findFactors(long tmp,int index)
	{
		//System.out.println("("+tmp+","+index+") called");
		if(tmp>y)
		{
			//System.out.println(tmp+" has exceeded "+Y);
			return;
		}
		if(index==size)
		{
			if(tmp>=x && tmp<=y)
			{
				//System.out.println("adding "+tmp);
				factors.add(tmp);
			}
			return;
		}
		for(int i=0;i<=maxPowers[index];i++)
		{
			findFactors(tmp*(long)Math.pow(primes[index], i),index+1);
		}
	}
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        while(n!=0)
        {
            size=n;
            primes=new int[n];
            for(int i=0;i<n;i++)
                primes[i]=sc.nextInt();
            x=sc.nextInt();
            y=sc.nextInt();
            maxPowers=new int[n];
            for(int i=0;i<n;i++)
                maxPowers[i]=(int)(Math.log(y)/Math.log(primes[i]));
            factors=new TreeSet<Long>();
            findFactors(1,0);
            if(factors.size()==0)
                System.out.println("none");
            else
            {
                while(true)
                {
                    long tmp=factors.pollFirst();
                    if(factors.isEmpty())
                    {
                        System.out.print(tmp);
                        break;
                    }
                    else
                        System.out.print(tmp+",");
                }
            }
            n=sc.nextInt();
            if(n!=0)
                System.out.println("");
        }
    }
}