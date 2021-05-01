/*
C++ solution for the problem Math Homework (https://open.kattis.com/problems/mathhomework)
Execution time: 0.04 s
Submitted on 2019-11-23 20:42:26
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>

using namespace std;

int main() {
    int b, d, c, l;
    cin >> b >> d >> c >> l;
    bool possible = false;
    for(int i=0;i<=l;i+=b){
        for(int j=0;j<=l && i+j<=l;j+=d){
            for(int k=0;k<=l && i+j+k<=l;k+=c){
                if(i+j+k==l){
                    cout << i/b << " " << j/d << " " << k/c << endl;
                    possible = true;
                }
            }
        }
    }
    if(!possible)
        cout << "impossible";
    return 0;
}