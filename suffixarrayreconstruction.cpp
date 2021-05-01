/*
C++ solution for the problem Suffix Array Re-construction (https://open.kattis.com/problems/suffixarrayreconstruction)
Execution time: 0.23 s
Submitted on 2020-01-19 23:21:06
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <vector>

using namespace std;

typedef unsigned long long ull;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;


int main() {
    ios::sync_with_stdio(false);
    int t;
    cin >> t;
    while (t--) {
        int l, s;
        cin >> l >> s;
        string arr(l, '*');
        string suffix;
        int p;
        bool possible = true;
        while (s--) {
            cin >> p >> suffix;
            for (int pos_in_arr = p - 1, pos_in_suffix = 0; pos_in_arr < l && possible;) {
                if (suffix[pos_in_suffix] == '*')
                    pos_in_arr += l - p + - (int) suffix.length() + 2;
                else {
                    if (arr[pos_in_arr] == '*')
                        arr[pos_in_arr] = suffix[pos_in_suffix];
                    else if (arr[pos_in_arr] != suffix[pos_in_suffix])
                        possible = false;
                    pos_in_arr++;
                }
                pos_in_suffix++;
            }
        }
        if (possible)
            for (char &c: arr)
                if (c == '*') {
                    possible = false;
                    break;
                }
        if (possible)
            cout << arr << endl;
        else
            cout << "IMPOSSIBLE" << endl;
    }
    return 0;
}