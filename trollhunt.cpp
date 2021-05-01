/*
C++ solution for the problem Troll Hunt (https://open.kattis.com/problems/trollhunt)
Execution time: 0.0 s
Submitted on 2019-12-06 08:00:52
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
    int b, k, g;
    cin >> b >> k >> g;
    int groups = k / g;
    double days = 1.0 * (b-1) / groups;
    if((int)days == days)
        cout << (int)days;
    else
        cout << (int)days + 1;
    return 0;
}