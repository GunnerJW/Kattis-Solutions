/*
Java solution for the problem Paradox With Averages (https://open.kattis.com/problems/averageseasy)
Execution time: 0.21 s
Submitted on 2017-03-22 18:49:05
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.text.*;
import java.math.*;
import java.util.regex.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt(),i;
        sc.nextLine();
        double ncs,ne,acs=0,ae=0;
        int num=0,j;
        for(i=0;i<n;i++)
        {
            sc.nextLine();
            ncs=sc.nextDouble();
            ne=sc.nextDouble();
            double[] cs=new double[(int)ncs];
            double[] e=new double[(int)ne];
            for(j=0;j<ncs;j++)
            {
                cs[j]=sc.nextDouble();
                acs+=cs[j];
            }
            acs/=ncs;
            for(j=0;j<ne;j++)
            {
                e[j]=sc.nextDouble();
                ae+=e[j];
            }
            ae/=ne;
            for(j=0;j<ncs;j++)
            {
                if(cs[j]<acs && cs[j]>ae)
                    num++;
            }
            System.out.println(num);
            num=0;
            acs=0;
            ae=0;
            if(sc.hasNext())
                sc.nextLine();
        }
    }
}
