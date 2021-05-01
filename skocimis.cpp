/*
C++ solution for the problem Skocimis (https://open.kattis.com/problems/skocimis)
Execution time: 0.0 s
Submitted on 2019-11-26 07:44:36
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <string>
#include <cmath>
#include <algorithm>

using namespace std;

int main() {
    int k1, k2, k3;
    cin >> k1 >> k2 >> k3;
    cout << max(k3 - k2, k2 - k1) - 1;
    return 0;
}