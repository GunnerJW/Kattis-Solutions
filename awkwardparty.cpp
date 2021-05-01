/*
C++ solution for the problem Awkward Party (https://open.kattis.com/problems/awkwardparty)
Execution time: 0.04 s
Submitted on 2019-12-02 08:17:19
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
    int n;
    cin >> n;
    unordered_map<int, int> last_seen;
    unordered_map<int, int> awkwardness;
    for (int i = 0; i < n; i++) {
        int x;
        cin >> x;
        if(last_seen.find(x) == last_seen.end()){
            last_seen[x] = i;
            awkwardness[x] = n;
        }
        else{
            awkwardness[x] = min(awkwardness[x], i - last_seen[x]);
            last_seen[x] = i;
        }
    }
    int res = n;
    for (auto& [lang, aw]: awkwardness) {
        res = min(res, aw);
    }
    cout << res;
    return 0;
}