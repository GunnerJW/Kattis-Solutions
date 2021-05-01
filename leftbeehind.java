/*
Java solution for the problem Left Beehind (https://open.kattis.com/problems/leftbeehind)
Execution time: 0.07 s
Submitted on 2017-03-06 14:47:45
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int x=sc.nextInt(),y=sc.nextInt();
        while(x!=0 || y!=0)
        {
            if(x+y==13)
                System.out.println("Never speak again.");
            else
            {
                if(x>y)
                    System.out.println("To the convention.");
                else if(x<y)
                    System.out.println("Left beehind.");
                else
                    System.out.println("Undecided.");
            }
            x=sc.nextInt();
            y=sc.nextInt();
        }
    }
}
