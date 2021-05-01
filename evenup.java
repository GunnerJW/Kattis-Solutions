/*
Java solution for the problem Even Up Solitaire (https://open.kattis.com/problems/evenup)
Execution time: 0.43 s
Submitted on 2018-05-08 21:23:09
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        Stack<Integer> s=new Stack<Integer>();
        for(int i=0;i<n;i++)
        {
            s.push(sc.nextInt());
            if(s.size()>=2)
            {
                int a=s.pop();
                int b=s.pop();
                if((a+b)%2!=0)
                {
                    s.push(b);
                    s.push(a);
                }
            }
        }
        System.out.println(s.size());
    }
}
