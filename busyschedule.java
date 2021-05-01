/*
Java solution for the problem Busy Schedule (https://open.kattis.com/problems/busyschedule)
Execution time: 0.21 s
Submitted on 2017-03-15 17:29:26
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),i=0;
        String[] arr=new String[2];
        char c='0';
        ArrayList<Integer> ao=new ArrayList<Integer>();
        ArrayList<Integer> atw=new ArrayList<Integer>();
        ArrayList<Integer> po=new ArrayList<Integer>();
        ArrayList<Integer> ptw=new ArrayList<Integer>();
        //ArrayList<String> al=new ArrayList<String>();
        //al.add("0");
        //String s="";
        while(n!=0)
        {
            for(i=0;i<n;i++)
            {
                arr=sc.next().split(":");
                c=sc.next().charAt(0);
                //s=arr[0].concat(" ").concat(arr[1]).concat(String.valueOf(c));
                //if(!al.contains(s))
                
                    //al.add(s);
                    if(Character.compare(c,'a')==0)
                    {
                        if(!arr[0].equals("12"))
                        {
                            ao.add(60*Integer.parseInt(arr[0])+Integer.parseInt(arr[1]));
                        }
                        else
                            atw.add(Integer.parseInt(arr[1]));
                    }
                    else
                    {
                        if(!arr[0].equals("12"))
                        {
                            po.add(60*Integer.parseInt(arr[0])+Integer.parseInt(arr[1]));
                        }
                        else
                            ptw.add(Integer.parseInt(arr[1]));
                    }
                                
            }
            Collections.sort(ao);
            Collections.sort(atw);
            Collections.sort(po);
            Collections.sort(ptw);
            for(int x:atw)
            {
                System.out.println("12:"+String.format("%02d",x)+" a.m.");
            }
            for(int x:ao)
            {
                System.out.println(x/60+":"+String.format("%02d",x%60)+" a.m.");
            }
            for(int x:ptw)
            {
                System.out.println("12:"+String.format("%02d",x)+" p.m.");
            }
            for(int x:po)
            {
                System.out.println(x/60+":"+String.format("%02d",x%60)+" p.m.");
            }
            ao.clear();
            atw.clear();
            po.clear();
            ptw.clear();
            //al.clear();
            //al.add("0");
            n=sc.nextInt();
            if(n!=0)
                System.out.println("");
        }
    }
}