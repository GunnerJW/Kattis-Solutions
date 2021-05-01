/*
C++ solution for the problem Closest Sums (https://open.kattis.com/problems/closestsums)
Execution time: 0.06 s
Submitted on 2019-12-13 21:08:02
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <algorithm>
#include <cmath>
#include <iomanip>
#include <vector>
#include <unordered_map>
#include <climits>

using namespace std;

typedef unsigned long long ull;


int main() {
    int t = 1;
    int n;
    while(scanf("%d", &n) == 1 && n){
        int arr[n];
        for(int i=0;i<n;i++)
            scanf("%d", &arr[i]);
        vector<int> sums;
        for(int i=0;i<n-1;i++)
            for(int j=i+1;j<n;j++)
                sums.push_back(arr[i] + arr[j]);
        sort(sums.begin(), sums.end());
        int m;
        scanf("%d", &m);
        cout << "Case " << t << ":" << endl;
        while(m--){
            int x;
            scanf("%d", &x);
            int i = 0;
            while(x > sums[i] && i < sums.size())
                i++;
            int closest;
            if(i==0)
                closest = sums[0];
            else if(i == sums.size())
                closest = sums[sums.size() - 1];
            else{
                int before = sums[i - 1];
                int after = sums[i];
                closest = abs(after - x) > abs(x - before) ? before : after;
            }
            cout << "Closest sum to " << x << " is " << closest << "." << endl;
        }
        t++;
    }
    return 0;
}