/*
Java solution for the problem Another Brick in the Wall (https://open.kattis.com/problems/anotherbrick)
Execution time: 0.16 s
Submitted on 2017-03-10 15:55:01
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int h=sc.nextInt(),w=sc.nextInt(),n=sc.nextInt(),i=0;
        ArrayList<Integer> al=new ArrayList<Integer>(n);
        for(i=0;i<n;i++)
            al.add(sc.nextInt());
        int f=1,sum=0,layer=1;
        i=0;
        lp:while(layer!=h+1)
        {
            while(sum<w)
            {
                sum+=al.get(i);
                i++;
            }
            if(sum==w)
            {
                sum=0;
                layer++;
            }
            else
            {
                System.out.println("NO");
                break lp;
            }
        }
        if(layer==h+1)
            System.out.println("YES");
    }
}
