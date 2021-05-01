/*
Java solution for the problem Average Speed (https://open.kattis.com/problems/averagespeed)
Execution time: 0.09 s
Submitted on 2017-05-04 20:50:37
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        double previousd=0,currV=0,qtime,currT=0;
        double thisd;
        int i=0;
        while(sc.hasNext())
        {
            String s=sc.nextLine();
            String[] arr1=s.split(" ");
            String[] arr2=arr1[0].split(":");
            if(arr1.length==2)
            {
                if(i==0)
                {
                    currV=Double.parseDouble(arr1[1])/3600;
                    currT=Double.parseDouble(arr2[0])*3600+Double.parseDouble(arr2[1])*60+Double.parseDouble(arr2[2]);
                    i++;
                }
                else
                {
                    previousd+=(Double.parseDouble(arr2[0])*3600+Double.parseDouble(arr2[1])*60+Double.parseDouble(arr2[2])-currT)*currV;
                    currV=Double.parseDouble(arr1[1])/3600;
                    currT=Double.parseDouble(arr2[0])*3600+Double.parseDouble(arr2[1])*60+Double.parseDouble(arr2[2]);
                }
            }
            else
            {
                qtime=Double.parseDouble(arr2[0])*3600+Double.parseDouble(arr2[1])*60+Double.parseDouble(arr2[2]);
                thisd=previousd+currV*(qtime-currT);
                System.out.print(s+" ");
                System.out.printf("%.2f",thisd);
                System.out.println(" km");
            }
        }
    }
}
