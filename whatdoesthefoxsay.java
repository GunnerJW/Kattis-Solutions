/*
Java solution for the problem What does the fox say? (https://open.kattis.com/problems/whatdoesthefoxsay)
Execution time: 0.09 s
Submitted on 2017-05-11 20:28:02
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int t=sc.nextInt();
        sc.nextLine();
        for(int i=0;i<t;i++)
        {
            String[] arr=sc.nextLine().split(" ");
            HashSet<String> hs=new HashSet<String>(100);
            String s=sc.nextLine();
            while(!s.equals("what does the fox say?"))
            {
                hs.add(s.split(" ")[2]);
                s=sc.nextLine();
            }
            for(String tmp:arr)
                if(!hs.contains(tmp))
                    System.out.print(tmp+" ");
            System.out.println("");
        }
    }
}