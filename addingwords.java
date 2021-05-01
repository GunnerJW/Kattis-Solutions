/*
Java solution for the problem Adding Words (https://open.kattis.com/problems/addingwords)
Execution time: 0.25 s
Submitted on 2018-04-30 03:26:26
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;

public class Solution {

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        HashMap<String,Integer> dic=new HashMap<String,Integer>(2000);
        HashMap<Integer,String> reverse=new HashMap<Integer,String>(2000);
        //String s;
        //String key;
        //int value;
        int sum=0;
        boolean broken=false;
        while(sc.hasNext())
        {
            String s=sc.next();
            if(s.equals("def"))
            {
                String key=sc.next();
                int value=sc.nextInt();
                if(dic.containsKey(key))
                {
                    reverse.remove(dic.get(key));
                    reverse.put(value,key);
                    dic.put(key,value);
                }
                else
                {
                    reverse.put(value,key);
                    dic.put(key,value);
                }
                sc.nextLine();
            }
            else if(s.equals("calc"))
            {
                s=sc.nextLine();
                String[] arr=s.split(" ");
                //System.out.println(Arrays.toString(arr));
                if(dic.containsKey(arr[1]))
                {
                    sum+=dic.get(arr[1]);
                    for(int i=2;i<arr.length-1;i+=2)
                    {
                        if(dic.containsKey(arr[i+1]))
                        {
                            if(arr[i].equals("+"))
                                sum+=dic.get(arr[i+1]);
                            else
                                sum-=dic.get(arr[i+1]);
                        }
                        else
                        {
                            System.out.println(s+" unknown");
                            broken=true;
                            break;
                        }
                    }
                    if(broken==false)
                    {
                        if(reverse.containsKey(sum))
                            System.out.println(s+" "+reverse.get(sum));
                        else
                            System.out.println(s+" unknown");
                    }
                }
                else
                {
                    System.out.println(s+" unknown");
                }
                sum=0;
                broken=false;
            }
            else
            {
                dic.clear();
                reverse.clear();
            }
        }
    }
}
