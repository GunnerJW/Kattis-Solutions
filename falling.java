/*
Java solution for the problem Falling Mugs (https://open.kattis.com/problems/falling)
Execution time: 0.07 s
Submitted on 2017-09-30 20:34:20
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;


public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        boolean broken=false;
        if(n%2==1)
            System.out.println(((n-1)/2)+" "+((n+1)/2));
        else
        {
             for(int i=2;i<=(int)Math.sqrt(n);i+=2)
            {
                if(n%i==0)
                {
                    if((i+n/i)%2==0 && (n/i-i)%2==0)
                    {
                        System.out.println(((n/i-i)/2)+" "+((n/i+i)/2));
                        broken=true;
                        break;
                    }
                }
            }
            if(broken==false)
                System.out.println("impossible");    
        }
    }
}
