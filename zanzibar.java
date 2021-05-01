/*
Java solution for the problem Stand on Zanzibar (https://open.kattis.com/problems/zanzibar)
Execution time: 0.08 s
Submitted on 2017-05-23 16:51:12
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int t=sc.nextInt();
        for(int i=0;i<t;i++)
        {
            ArrayList<Integer> al=new ArrayList<Integer>();
            int x=sc.nextInt();
            while(x!=0)
            {
                al.add(x);
                x=sc.nextInt();
            }
            int lower_bound=0;
            for(int j=0;j<al.size()-1;j++)
            {
                int diff=al.get(j+1)-2*al.get(j);
                if(diff>0)
                    lower_bound+=diff;
            }
            System.out.println(lower_bound);
        }
    }
}
