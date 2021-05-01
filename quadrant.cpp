/*
C++ solution for the problem Quadrant Selection (https://open.kattis.com/problems/quadrant)
Execution time: 0.0 s
Submitted on 2019-11-18 13:47:31
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>

using namespace std;

int main() {
    int x, y;
    cin >> x >> y;
    int q;
    if(x > 0)
        if(y > 0)
            q = 1;
        else
            q = 4;
    else
        if(y > 0)
            q = 2;
        else
            q = 3;
    cout << q;
    return 0;
}