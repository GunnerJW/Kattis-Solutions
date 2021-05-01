/*
C++ solution for the problem Kattis's Quest (https://open.kattis.com/problems/kattissquest)
Execution time: 0.11 s
Submitted on 2020-02-18 23:28:51
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

// kattissquest
#include <iostream>
#include <vector>
#include <map>
#include <queue>

using namespace std;

typedef unsigned long long ull;
typedef unsigned long ul;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n;
    cin >> n;
    map<int, priority_queue<int>> dict;
    while(n--){
        string cmd;
        cin >> cmd;
        if(cmd == "add"){
            int e, g;
            cin >> e >> g;
            dict[e].push(g);
        }
        else{
            int x;
            cin >> x;
            ull res = 0;
            while(!dict.empty()){
                auto it = dict.lower_bound(x);
                if(it == dict.end())
                    it--;
                while(it != dict.begin() && it->first > x)
                    it--;
                if(it->first > x)
                    break;
                x -= it->first;
                res += it->second.top();
                it->second.pop();
                if(it->second.empty())
                    dict.erase(it);
            }
            cout << res << "\n";
        }
    }
}