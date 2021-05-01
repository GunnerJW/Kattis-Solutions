/*
C++ solution for the problem Non-Prime Factors (https://open.kattis.com/problems/nonprimefactors)
Execution time: 0.45 s
Submitted on 2020-02-08 21:15:50
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <vector>

using namespace std;

typedef unsigned long long ull;
typedef unsigned long ul;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    ul MAX = 2'000'000;
    vector<int> npf(MAX + 1, 1);
    vector<bool> ip(MAX + 1, true);
    for (ul i = 2; i <= MAX; i++) {
        if (!ip[i]) {
            int x = i;
            while (x <= MAX) {
                npf[x]++;
                x += i;
            }
        }
        else {
            for(ul x = i * i; x <= MAX; x += i)
                ip[x] = false;
        }
    }
    int t;
    cin >> t;
    while(t--){
        int n;
        cin >> n;
        cout << npf[n] << "\n";
    }
}