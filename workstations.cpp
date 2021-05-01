/*
C++ solution for the problem Assigning Workstations (https://open.kattis.com/problems/workstations)
Execution time: 0.1 s
Submitted on 2020-01-13 22:16:36
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


int main() {
    ios::sync_with_stdio(false);
    int n, m;
    cin >> n >> m;
//    scanf("%d %d", &n, &m);
    vector<pair<int, int>> r;
    r.reserve(n);
    for(int i=0;i<n;i++){
        int arrival, dur;
//        scanf("%d %d", &arrival, &dur);
        cin >> arrival >> dur;
        r.emplace_back(make_pair(arrival, dur));
    }
    sort(r.begin(), r.end());
    priority_queue<pair<int, int>, vector<pair<int, int>>, greater<>> pq;
    int res = 0;
    for(auto tuple: r){
        int arrival = tuple.first;
        int end = arrival + tuple.second;
        while(!pq.empty() && (arrival > pq.top().second))
            pq.pop();
        if(!pq.empty()){
            int x = pq.top().first;
            if(x <= arrival){
                res++;
                pq.pop();
            }
        }
        pq.push(make_pair(end, end + m));
    }
    cout << res;
//    printf("%d", res);
    return 0;
}