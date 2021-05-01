/*
Java solution for the problem Judging Troubles (https://open.kattis.com/problems/judging)
Execution time: 0.72 s
Submitted on 2017-05-15 19:44:18
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int n=sc.nextInt();
        sc.nextLine();
        HashMap<String,Integer> dom=new HashMap<String,Integer>(n);
        for(int i=0;i<n;i++)
        {
            String s=sc.nextLine();
            if(dom.containsKey(s))
                dom.put(s,dom.get(s)+1);
            else
                dom.put(s,1);
        }
        HashMap<String,Integer> kattis=new HashMap<String,Integer>(n);
        for(int i=0;i<n;i++)
        {
            String s=sc.nextLine();
            if(kattis.containsKey(s))
                kattis.put(s,kattis.get(s)+1);
            else
                kattis.put(s,1);
        }
        int x=0;
        HashSet<String> hs=new HashSet<String>(dom.keySet());
        for(String tmp : hs)
            if(kattis.get(tmp)!=null)
                x+=Math.min(kattis.get(tmp),dom.get(tmp));
        System.out.println(x);
    }
}
