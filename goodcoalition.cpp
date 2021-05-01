/*
C++ solution for the problem Good Coalition (https://open.kattis.com/problems/goodcoalition)
Execution time: 0.01 s
Submitted on 2020-01-17 22:08:19
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

int n;
vi seats_won;
vector<ld> probas;
vector<vector<ld>> memo;
vector<ld> DEF(151, -1.0);

ld run(int index, int seats) {
    if (index == n) {
        if (seats < 76)
            return 0.0;
        return 1.0;
    }
    if (memo[index][seats] != -1.0)
        return memo[index][seats];
    ld res = max(probas[index] * run(index + 1, seats + seats_won[index]), run(index + 1, seats));
    return memo[index][seats] = res;
}

int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        cin >> n;
        seats_won.clear();
        seats_won.reserve(n);
        probas.clear();
        probas.reserve(n);
        for (int i = 0; i < n; i++) {
            int s;
            ld p;
            cin >> s >> p;
            seats_won.push_back(s);
            probas.push_back(p / 100);
        }
        memo.clear();
        memo.reserve(n);
        for(int i = 0;i < n;i++)
            memo.push_back(DEF);
        ld res = run(0, 0);
        cout << setprecision(15) << fixed << res * 100 << endl;
    }
    return 0;
}