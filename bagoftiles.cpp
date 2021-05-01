/*
C++ solution for the problem Bag of Tiles (https://open.kattis.com/problems/bagoftiles)
Execution time: 1.52 s
Submitted on 2020-01-25 15:20:02
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <vector>

using namespace std;

typedef unsigned long long ull;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;

int m, n, t;
vi labels;
vector<int> DEF(31, 1);
vector<vector<int>> binomial_coeffs(31, DEF);
int memo[30][31][10000];


int play(int index, int picked, int label_sum) {
    if (label_sum > t)
        return 0;
    if (picked == n) {
        if (label_sum == t)
            return 1;
        return 0;
    }
    if (index == m)
        return 0;
    if (memo[index][picked][label_sum] != -1)
        return memo[index][picked][label_sum];
    int res = play(index + 1, picked + 1, label_sum + labels[index]) +
              play(index + 1, picked, label_sum);
    return memo[index][picked][label_sum] = res;
}

int main() {
    for (int nn = 2; nn <= 30; nn++)
        for (int k = 1; k < nn; k++)
            binomial_coeffs[nn][k] = binomial_coeffs[nn - 1][k - 1] + binomial_coeffs[nn - 1][k];

    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int games;
    cin >> games;
    for (int game = 1; game <= games; game++) {
        cin >> m;
        labels.clear();
        labels.resize(m);
        for (int &x: labels)
            cin >> x;
        cin >> n >> t;
        for (int i = 0; i < m; i++)
            for (int j = 0; j <= m; j++)
                for (int k = 0; k < 10000; k++)
                    memo[i][j][k] = -1;
        int winning = play(0, 0, 0);
        int losing = binomial_coeffs[m][n] - winning;
        cout << "Game " << game << " -- " << winning << " : " << losing << "\n";
    }
    return 0;
}