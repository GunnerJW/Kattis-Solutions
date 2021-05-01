/*
Java solution for the problem Jumbled Compass (https://open.kattis.com/problems/compass)
Execution time: 0.07 s
Submitted on 2017-09-30 20:38:48
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt(),y=sc.nextInt();
        int a=0;
        if(x==y)
            System.out.println(0);
        else if(x<y)
        {
            a=360+x-y;
            if(y-x<=a)
                System.out.println(y-x);
            else
                System.out.println(-1*a);
        }
        else
        {
            a=360+y-x;
            if(a<=x-y)
                System.out.println(a);
            else
                System.out.println(y-x);
        }
    }
}
