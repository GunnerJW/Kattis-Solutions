/*
C++ solution for the problem Birthday Party (https://open.kattis.com/problems/birthday)
Execution time: 0.19 s
Submitted on 2020-01-04 13:03:19
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <unordered_map>
#include <queue>
#include <cmath>
#include <algorithm>
#include <iomanip>
#include <stack>
#include <bitset>

using namespace std;

typedef unsigned long long ull;
typedef vector<int> vi;

class UnionFind {                                // OOP style
private:
    vi p, rank, setSize;                           // vi p is the key part
    int numSets;
public:
    UnionFind(int N) {
        p.assign(N, 0);
        for (int i = 0; i < N; ++i) p[i] = i;
        rank.assign(N, 0);                           // optional speedup
        setSize.assign(N, 1);                        // optional feature
        numSets = N;                                 // optional feature
    }

    int findSet(int i) { return (p[i] == i) ? i : (p[i] = findSet(p[i])); }

    bool isSameSet(int i, int j) { return findSet(i) == findSet(j); }

    int numDisjointSets() { return numSets; }      // optional
    int sizeOfSet(int i) { return setSize[findSet(i)]; } // optional

    void unionSet(int i, int j) {
        if (isSameSet(i, j)) return;                 // i and j are in same set
        int x = findSet(i), y = findSet(j);          // find both rep items
        if (rank[x] > rank[y]) swap(x, y);           // keep x 'shorter' than y
        p[x] = y;                                    // set x under y
        if (rank[x] == rank[y]) ++rank[y];           // optional speedup
        setSize[y] += setSize[x];                    // combine set sizes at y
        --numSets;                                   // a union reduces numSets
    }
};


int main() {
    ios::sync_with_stdio(false);
    while (true) {
        int p, c;
        cin >> p >> c;
        if(p + c == 0)
            break;
        vector<pair<int, int>> v;
        v.reserve(c);
        for(int i=0;i<c;i++){
            int a, b;
            cin >> a >> b;
            v.emplace_back(a, b);
        }
        string verdict = "No";
        for(int i=0;i<c;i++){
            UnionFind uf(p);
            for(int j=0;j<c;j++){
                if(j == i)
                    continue;
                uf.unionSet(v[j].first, v[j].second);
            }
            if(uf.numDisjointSets() != 1){
                verdict = "Yes";
                break;
            }
        }
        cout << verdict << endl;
    }
    return 0;
}