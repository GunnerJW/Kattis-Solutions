/*
Java solution for the problem Cetiri (https://open.kattis.com/problems/cetiri)
Execution time: 0.07 s
Submitted on 2017-03-01 04:01:04
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

    public class Solution{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int[] arr=new int[3];
        arr[0]=sc.nextInt();
        arr[1]=sc.nextInt();
        arr[2]=sc.nextInt();
        Arrays.sort(arr);
        int[] diff=new int[2];
        diff[0]=arr[1]-arr[0];
        diff[1]=arr[2]-arr[1];
        if(diff[0]==diff[1])
            System.out.println(arr[2]+diff[0]);
        else if(diff[0]>diff[1])
            System.out.println(arr[0]+diff[0]/2);
        else
            System.out.println(arr[1]+diff[1]/2);       
    }
}
