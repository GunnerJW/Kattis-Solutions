/*
Java solution for the problem Yoda (https://open.kattis.com/problems/yoda)
Execution time: 0.07 s
Submitted on 2017-04-12 16:49:11
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.io.*;
import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int a=sc.nextInt();
        int b=sc.nextInt();
        int da=(int)Math.floor(Math.log10(a))+1;
        int db=(int)Math.floor(Math.log10(b))+1;
        int maxd=(da>=db)?da:db;
        int[] arra=new int[maxd];
        int[] arrb=new int[maxd];
        for(int i=maxd-1;i>=0;i--)
        {
            arra[i]=a%10;
            arrb[i]=b%10;
            a/=10;
            b/=10;
        }
        //System.out.println(Arrays.toString(arra));
        //System.out.println(Arrays.toString(arrb));
        for(int i=maxd-1;i>=0;i--)
        {
            if(arra[i]>arrb[i])
                arrb[i]=-1;
            else if(arra[i]<arrb[i])
                arra[i]=-1;
        }
        //System.out.println(Arrays.toString(arra));
        //System.out.println(Arrays.toString(arrb));
        a=0;
        b=0;
        int powa=1,powb=1;
        for(int i=maxd-1;i>=0;i--)
        {
            if(arra[i]!=-1)
            {
                a+=arra[i]*powa;
                powa*=10;
            }
            if(arrb[i]!=-1)
            {
                b+=arrb[i]*powb;
                powb*=10;
            }
        }
        if(powa==1)
            System.out.println("YODA");
        else
            System.out.println(a);
        if(powb==1)
            System.out.println("YODA");
        else
            System.out.println(b);
    }
}
