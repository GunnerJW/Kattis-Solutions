/*
Java solution for the problem Secure Doors (https://open.kattis.com/problems/securedoors)
Execution time: 0.13 s
Submitted on 2017-03-07 23:16:24
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt(),i=0;
        String event="",name="",action="";
        Hashtable<String,String> ht=new Hashtable<String,String>(n);
        for(i=0;i<n;i++)
        {
            event=sc.next();
            name=sc.next();
            action=event.equals("entry")?"entered":"exited";
            if(!ht.containsKey(name))
            {
                if(event.equals("exit"))
                {
                    System.out.println(name+" "+action+" (ANOMALY)");
                    ht.put(name,event);
                }
                else
                {
                    System.out.println(name+" "+action);
                    ht.put(name,event);
                }
            }
            else
            {
                if(ht.get(name).equals(event))
                {
                    System.out.println(name+" "+action+" (ANOMALY)");
                    ht.put(name,event);
                }
                else
                {
                    System.out.println(name+" "+action);
                    ht.put(name,event);
                }
            }    
        }
    }
}