/*
C++ solution for the problem Game of Throwns (https://open.kattis.com/problems/throwns)
Execution time: 0.0 s
Submitted on 2020-01-31 20:33:57
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <vector>
#include <stack>

using namespace std;

typedef unsigned long long ull;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;


int main() {
    ios::sync_with_stdio(false);
    cin.tie(nullptr);
    int n, k;
    cin >> n >> k;
    stack<int> st;
    while(k--){
        string s;
        cin >> s;
        try{
            int x = stoi(s);
            st.push(x);
        }
        catch(invalid_argument& e){
            int x;
            cin >> x;
            while(x--)
                st.pop();
        }
    }
    int res = 0;
    while(!st.empty()){
        res += st.top();
        st.pop();
    }
    res %= n;
    if(res < 0)
        cout << res + n;
    else
        cout << res;
    return 0;
}