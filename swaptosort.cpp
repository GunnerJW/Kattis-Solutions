/*
C++ solution for the problem Swap to Sort (https://open.kattis.com/problems/swaptosort)
Execution time: 0.2 s
Submitted on 2020-01-03 21:33:57
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
        p.assign(N, 0); for (int i = 0; i < N; ++i) p[i] = i;
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
    int n, k;
    cin >> n >> k;
    UnionFind uf(n);
    while(k--){
        int a, b;
        cin >> a >> b;
        a--;
        b--;
        uf.unionSet(a, b);
    }
    string verdict = "Yes";
    for(int i = 0;i<= n / 2;i++){
        if(!uf.isSameSet(i, n - 1 - i)){
            verdict = "No";
            break;
        }
    }
    cout << verdict;
    return 0;
}