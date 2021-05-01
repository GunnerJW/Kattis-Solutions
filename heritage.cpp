/*
C++ solution for the problem What Does It Mean? (https://open.kattis.com/problems/heritage)
Execution time: 0.0 s
Submitted on 2019-12-28 11:43:21
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <unordered_map>
#include <queue>

using namespace std;

typedef unsigned long long ull;

const ull MOD = 1000000007;

string family_name;
int n;
unordered_map<string, ull> dict;
vector<ull> dp(10000, -1);

bool startswith(unsigned int index, string word){
    return (family_name.substr(index).find(word) == 0);
}

ull run(unsigned int index){
    if(index >= family_name.length())
        return 1;
    if(dp[index] != -1)
        return dp[index];
    ull res = 0;
    for(auto& s: dict){
        if(startswith(index, s.first)){
            res += s.second * run(index + s.first.length());
        }
    }
    res %= MOD;
    dp[index] = res;
    return res;
}

int main() {
    ios::sync_with_stdio(false);
    cin >> n >> family_name;
    for(int i=0;i<n;i++){
        string s;
        ull x;
        cin >> s >> x;
        dict[s] = x;
    }
    cout << run(0);
    return 0;
}