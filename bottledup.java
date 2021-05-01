/*
Java solution for the problem Bottled-Up Feelings (https://open.kattis.com/problems/bottledup)
Execution time: 0.07 s
Submitted on 2017-05-16 20:18:11
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

public class Solution{
    static int v1;
    static int v2;
    static int b1;
    static int b2;
    static void fill(int curr){
        if(curr==0)
            return;
        if(b1==0 && curr!=0){
            b1=-1;
            return;
        }
        b1-=1;
        curr+=v1;
        b2+=curr/v2;
        curr-=v2*(curr/v2);
        fill(curr);
        return;
    }
    public static void main(String[] args){
        Scanner sc=new Scanner(System.in);
        int shipment=sc.nextInt();
        v1=sc.nextInt();
        v2=sc.nextInt();
        sc.close();
        b1=shipment/v1;
        b2=(shipment%v1)/v2;
        int rest=shipment-v1*b1-v2*b2;
        fill(rest);
        if(b1==-1)
            System.out.println("Impossible");
        else
            System.out.println(b1+" "+b2);
    }
}