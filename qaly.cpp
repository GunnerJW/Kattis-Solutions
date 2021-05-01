/*
C++ solution for the problem Quality-Adjusted Life-Year (https://open.kattis.com/problems/qaly)
Execution time: 0.0 s
Submitted on 2019-11-17 12:54:43
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
using namespace std;

int main(){
    int periods;
    cin >> periods;
    float res=0;
    for(int i=0;i<periods;i++){
        float p,q;
        cin >> q;
        cin >> p;
        res += p * q;
    }
    cout << res;
}