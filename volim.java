/*
Java solution for the problem Volim (https://open.kattis.com/problems/volim)
Execution time: 0.07 s
Submitted on 2017-02-25 20:48:46
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc=new Scanner(System.in);
        int curr=sc.nextInt(),q=sc.nextInt();
        int i=0;
        int t=0;
        int elaps=0;
        char c='x';
        for(i=0;i<q;i++)
        {
            t=sc.nextInt();
            c=sc.next().charAt(0);
            elaps+=t;
            if(elaps>=210)
            {
                if(curr==8)
                    System.out.println(8);
                else
                    System.out.println(curr%8);
                break;
            }
            if(c=='T')
            {
                curr++;
            }
        }
    }
}
