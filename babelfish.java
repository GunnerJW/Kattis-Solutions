/*
Java solution for the problem Babelfish (https://open.kattis.com/problems/babelfish)
Execution time: 1.21 s
Submitted on 2017-03-12 01:57:40
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;
import java.math.BigInteger;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        Hashtable<String,String> ht=new Hashtable<String,String>();
        String s=sc.nextLine();
        String[] arr=new String[2];
        while(!s.equals(""))
        {
            arr=s.split(" ");
            ht.put(arr[1],arr[0]);
            s=sc.nextLine();
        }
        String message="";
        while(sc.hasNext())
        {
            message=sc.nextLine();
            if(ht.containsKey(message))
                System.out.println(ht.get(message));
            else
                System.out.println("eh");
        }
      }
}