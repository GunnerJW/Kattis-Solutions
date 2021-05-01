/*
Java solution for the problem Line Them Up (https://open.kattis.com/problems/lineup)
Execution time: 0.07 s
Submitted on 2017-02-27 02:29:33
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        /* Enter your code here. Read input from STDIN. Print output to STDOUT. Your class should be named Solution. */
        Scanner sc=new Scanner(System.in);
        int n=sc.nextInt();
        String[] arr=new String[n];
        for(int i=0;i<n;i++)
        {
            arr[i]=sc.next();
        }
        String[] inc=arr.clone();
        Arrays.sort(inc);
        String[] dec=inc.clone();
        String tmp="";
        for(int i=0;i<dec.length/2;i++)
        {
            tmp=dec[i];
            dec[i]=dec[n-i-1];
            dec[n-i-1]=tmp;
        }
        if(Arrays.equals(arr,inc))
            System.out.println("INCREASING");
        else if(Arrays.equals(arr,dec))
            System.out.println("DECREASING");
        else
            System.out.println("NEITHER");
        //System.out.println(Arrays.toString(inc));
    }
}