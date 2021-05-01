/*
C++ solution for the problem Bobby's Bet (https://open.kattis.com/problems/bobby)
Execution time: 0.04 s
Submitted on 2019-12-28 10:49:47
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <unordered_set>
#include <queue>

using namespace std;

int r, s, x, y, w;

double run(int throw_, int successful_attempts) {
    if (throw_ > y) {
        if(successful_attempts >= x)
            return 1.0 * w;
        return 0.0;
    }
    double more = 1.0 * (s - r + 1) / s;
    double less = 1.0 - more;
    return more * run(throw_ + 1, successful_attempts + 1) +
           less * run(throw_ + 1, successful_attempts);
}

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        cin >> r >> s >> x >> y >> w;
        double res = run(1, 0);
        cout << (res > 1.0 ? "yes": "no") << endl;
    }
    return 0;
}