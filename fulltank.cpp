/*
C++ solution for the problem Full Tank? (https://open.kattis.com/problems/fulltank)
Execution time: 1.04 s
Submitted on 2020-01-14 19:34:45
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
vector<vector<pair<int, int>>> graph;
vi prices;
int INF = 1'000'000;


vi dijkstra(int s, int e, int c) {
    vector<vi> spending;
    spending.reserve(n);
    vi default_(c + 1, INF);
    for (int i = 0; i < n; i++)
        spending.push_back(default_);
    spending[s][0] = 0;
    priority_queue<pair<int, pii>, vector<pair<int, pii>>, greater<>> pq;
    pq.push(make_pair(0, make_pair(s, 0)));

    while (!pq.empty()) {
        auto p = pq.top();
        pq.pop();
        int sp = p.first;
        int city = p.second.first;
        int fuel = p.second.second;
        if (sp > spending[city][fuel])
            continue;
        if ((fuel + 1 <= c) && (sp + prices[city] < spending[city][fuel + 1])) {
            spending[city][fuel + 1] = sp + prices[city];
            pq.push(make_pair(sp + prices[city], make_pair(city, fuel + 1)));
        }
        for (auto adj: graph[city]) {
            int c2 = adj.first;
            int w = adj.second;
            if (fuel - w < 0)
                continue;
            if (sp >= spending[c2][fuel - w])
                continue;
            spending[c2][fuel - w] = sp;
            pq.push(make_pair(sp, make_pair(c2, fuel - w)));
        }
    }
    return spending[e];
}

int main() {
    ios::sync_with_stdio(false);
    int m;
    cin >> n >> m;
    prices.resize(n);
    for (int &p: prices)
        cin >> p;
    graph.resize(n);
    for (int i = 0; i < m; i++) {
        int u, v, w;
        cin >> u >> v >> w;
        graph[u].emplace_back(make_pair(v, w));
        graph[v].emplace_back(make_pair(u, w));
    }
    int q;
    cin >> q;
    while (q--) {
        int s, e, c;
        cin >> c >> s >> e;
        auto x = dijkstra(s, e, c);
        int res = *min_element(x.begin(), x.end());
        if(res == INF)
            cout << "impossible" << endl;
        else
            cout << res << endl;
    }
    return 0;
}