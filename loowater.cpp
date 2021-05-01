/*
C++ solution for the problem The Dragon of Loowater (https://open.kattis.com/problems/loowater)
Execution time: 0.05 s
Submitted on 2020-02-21 20:53:53
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <vector>
#include <cmath>
#include <set>
#include <algorithm>

using namespace std;

typedef unsigned long long ull;
typedef unsigned long ul;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;

int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, m;
    cin >> n >> m;
    while(n){
        vi heads(n, 0);
        for(int& x: heads)
            cin >> x;
        sort(heads.begin(), heads.end(), greater<>());
        multiset<int> knights;
        for(int i = 0;i < m;i++){
            int x;
            cin >> x;
            knights.insert(x);
        }
        bool doomed = false;
        ull cost = 0;
        for(int head: heads){
            if(knights.empty()){
                doomed = true;
                break;
            }
            auto it = knights.lower_bound(head);
            if(it == knights.end()){
                doomed = true;
                break;
            }
            while(it != knights.end() && (*it) < head)
                it++;
            cost += *it;
            knights.erase(it);
        }
        if(doomed)
            cout << "Loowater is doomed!\n";
        else
            cout << cost << "\n";
        cin >> n >> m;
    }
}