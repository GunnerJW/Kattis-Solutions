/*
Java solution for the problem Virus Replication (https://open.kattis.com/problems/virus)
Execution time: 0.15 s
Submitted on 2017-10-19 20:37:02
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;
import java.io.*;

public class Solution
{
    public static void main(String[] args)
    {
        Scanner sc=new Scanner(System.in);
        String before=sc.nextLine();
        int l1=before.length();
        String after=sc.nextLine();
        int l2=after.length();
        int i=0;
        int j=0;
        while(i<l1 && i<l2 && before.charAt(i)==after.charAt(i))
        {
            i++;
        }
        while(j<l1 && j<l2 && before.charAt(l1-1-j)==after.charAt(l2-1-j))
        {
            j++;
        }
        j=l2-j;
        int ans=0;
        if(j-i>0)
            ans=j-i;
        System.out.println(Math.max(ans,l2-l1));
    }
}