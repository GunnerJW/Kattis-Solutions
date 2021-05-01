/*
Java solution for the problem Santa Klas (https://open.kattis.com/problems/santaklas)
Execution time: 0.07 s
Submitted on 2017-03-26 02:50:55
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int h=sc.nextInt(),a=sc.nextInt();
        if(a>=0 && a<=180)
            System.out.println("safe");
        else
        {
            System.out.println((int)(h/Math.cos((270-a)*Math.PI/180)));
        }
        //System.out.println(Math.cos(90));
      }
}