/*
C++ solution for the problem Combination Lock (https://open.kattis.com/problems/combinationlock)
Execution time: 0.01 s
Submitted on 2019-12-07 12:21:03
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <vector>
#include <unordered_map>
#include <climits>

using namespace std;


int main() {
    int pos, a, b, c;
    cin >> pos >> a >> b >> c;
    while (pos + a + b + c != 0) {
        int res = 40;
        // steps 1 & 2
        res += 40;
        int tmp = pos - a;
        if(tmp < 0)
            tmp += 40;
        res += tmp;
        pos = a;
        // steps 3 & 4
        tmp = b - pos;
        if (tmp < 0)
            tmp += 40;
        res += tmp + 40;
        pos = b;
        // step 5
        tmp = pos - c;
        if (tmp < 0)
            tmp += 40;
        res += tmp;
        cout << res * 9 << endl;
        cin >> pos >> a >> b >> c;
    }
    return 0;
}