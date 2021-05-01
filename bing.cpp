/*
C++ solution for the problem Bing It On (https://open.kattis.com/problems/bing)
Execution time: 0.26 s
Submitted on 2020-01-17 22:42:03
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
    unordered_map<string, int> prefixes;
    int t;
    cin >> t;
    while (t--) {
        string word;
        cin >> word;
        int l = word.length();
        cout << prefixes[word] << endl;
        for(int i = 1; i<= l;i++)
            prefixes[word.substr(0, i)]++;
    }
    return 0;
}