/*
Java solution for the problem Sum of the Others (https://open.kattis.com/problems/sumoftheothers)
Execution time: 0.1 s
Submitted on 2017-03-08 17:32:19
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s="";
        int sum=0;
        while(sc.hasNext())
        {
            s=sc.nextLine();
            String[] arr=s.split(" ");
            for(int i=0;i<arr.length;i++)
                sum+=Integer.parseInt(arr[i]);
            System.out.println(sum/2);
            sum=0;
        }
    }
}
