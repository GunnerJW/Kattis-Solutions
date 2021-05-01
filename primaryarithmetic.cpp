/*
C++ solution for the problem Primary Arithmetic (https://open.kattis.com/problems/primaryarithmetic)
Execution time: 0.0 s
Submitted on 2019-12-06 08:22:11
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <vector>
#include <unordered_map>

using namespace std;

int main() {
    long a, b;
    cin >> a >> b;
    while(a != 0 || b != 0){
        int res = 0;
        int carry = 0;
        while(a != 0 || b != 0){
            int tmp = a % 10 + b % 10 + carry;
            if(tmp >= 10){
                carry = 1;
                res++;
            }
            else
                carry = 0;
            a /= 10;
            b /= 10;
        }
        if(res == 0)
            cout << "No carry operation." << endl;
        else if(res == 1)
            cout << "1 carry operation." << endl;
        else
            cout << res << " carry operations." << endl;
        cin >> a >> b;
    }
    return 0;
}