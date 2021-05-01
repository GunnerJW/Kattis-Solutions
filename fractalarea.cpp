/*
C++ solution for the problem Fractal Area (https://open.kattis.com/problems/fractalarea)
Execution time: 0.0 s
Submitted on 2020-01-17 21:33:38
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <map>
#include <queue>
#include <cmath>
#include <iomanip>
#include <stack>
#include <bitset>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>

using namespace std;

typedef unsigned long long ull;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;


int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    vector<ld> res;
    res.push_back(0);
    res.push_back(1);
    res.push_back(2);
    for(int i=3;i<=50;i++){
        res.push_back(res[i - 1] + 4.0 * powl(3.0, (i - 2)) / powl(4.0, i - 1));
    }
    while(t--){
        ld r;
        int n;
        cin >> r >> n;
        cout << setprecision(15) << fixed << M_PI * r * r * res[n] << endl;
    }
    return 0;
}