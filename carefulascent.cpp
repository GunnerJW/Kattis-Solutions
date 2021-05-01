/*
C++ solution for the problem Careful Ascent (https://open.kattis.com/problems/carefulascent)
Execution time: 0.0 s
Submitted on 2019-11-24 13:56:55
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <algorithm>
#include <vector>
#include <tuple>
#include <iomanip>

using namespace std;

int main() {
    int x, y;
    cin >> x >> y;
    int t;
    cin >> t;
    vector<tuple<int, int, double>> arr;
    for (int i = 0; i < t; i++) {
        int l;
        int u;
        double f;
        cin >> l >> u >> f;
        arr.push_back(tuple<int, int, double>(l, u, f));
    }
    sort(arr.begin(), arr.end());
    double den = 0;
    int curr = 0;
    for(tuple<int, int, double>& tp: arr){
        den += get<0>(tp) - curr;
        den += (get<1>(tp) - get<0>(tp)) * get<2>(tp);
        curr = get<1>(tp);
    }
    den += y - curr;
    cout << setprecision(10) << x / den;
    return 0;
}