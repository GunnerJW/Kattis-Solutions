/*
Java solution for the problem Imperial Measurement (https://open.kattis.com/problems/measurement)
Execution time: 0.08 s
Submitted on 2017-05-11 20:19:12
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {
    
    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        HashMap<String,String> names=new HashMap<String,String>(7);
        names.put("thou","th");
        names.put("inch","in");
        names.put("foot","ft");
        names.put("yard","yd");
        names.put("chain","ch");
        names.put("furlong","fur");
        names.put("mile","mi");
        names.put("league","lea");
        HashMap<String,Integer> values=new HashMap<String,Integer>(7);
        values.put("th",1);
        values.put("in",1000);
        values.put("ft",12000);
        values.put("yd",36000);
        values.put("ch",792000);
        values.put("fur",7920000);
        values.put("mi",63360000);
        values.put("lea",190080000);
        double x=sc.nextDouble();
        String src=sc.next();
        sc.next();
        String dst=sc.next();
        if(values.containsKey(src))
            x*=values.get(src);
        else
            x*=values.get(names.get(src));
        if(values.containsKey(dst))
            x/=values.get(dst);
        else
            x/=values.get(names.get(dst));
        System.out.println(x);
    }
}