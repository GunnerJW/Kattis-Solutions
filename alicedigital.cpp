/*
C++ solution for the problem Alice in the Digital World (https://open.kattis.com/problems/alicedigital)
Execution time: 0.03 s
Submitted on 2020-01-26 10:41:21
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
    cin.tie(nullptr);
    int t;
    cin >> t;
    while(t--){
        int n, m;
        cin >> n >> m;
        vi arr(n), m_positions;
        for(int i = 0;i<n;i++){
            cin >> arr[i];
            if(arr[i] == m)
                m_positions.push_back(i);
        }
        int res = 0;
        for(int& pos: m_positions){
            int sum = m;
            for(int i = pos - 1;i >= 0;i--){
                if(arr[i] <= m)
                    break;
                sum += arr[i];
            }
            for(int i = pos + 1; i < n;i++){
                if(arr[i] <= m)
                    break;
                sum += arr[i];
            }
            res = max(res, sum);
        }
        cout << res << '\n';
    }
    return 0;
}