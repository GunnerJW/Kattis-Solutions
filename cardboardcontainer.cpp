/*
C++ solution for the problem Cardboard Container (https://open.kattis.com/problems/cardboardcontainer)
Execution time: 0.02 s
Submitted on 2019-12-07 22:11:20
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
    int v;
    cin >> v;
    int l, w, h;
    int tmp, tmp2;
    int res = INT_MAX;
    for (int i = 1; i <= v; i++) {
        tmp = v;
        if (tmp % i == 0) {
            l = i;
            tmp /= i;
            for (int j = 1; j <= tmp; j++) {
                tmp2 = tmp;
                if (tmp2 % j == 0) {
                    w = j;
                    tmp2 /= j;
                    h = tmp2;
//                    cout << l << " " << w << " " << h << endl;
                    res = min(res, 2 * (l * h + h * w + l * w));
                }
            }
        }
    }
    cout << res;
    return 0;
}