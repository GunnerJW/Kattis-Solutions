/*
C++ solution for the problem Jolly Jumpers (https://open.kattis.com/problems/jollyjumpers)
Execution time: 0.0 s
Submitted on 2019-12-21 21:57:53
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <unordered_set>

using namespace std;


int main() {
    int n;
    while(scanf("%d", &n) == 1){
        int arr[n];
        for(int i=0;i<n;i++)
            scanf("%d", &arr[i]);
        unordered_set<int> diff;
        for(int i=1;i<n;i++)
            diff.insert(i);
        for(int i=1;i<n;i++)
            diff.erase(abs(arr[i] - arr[i-1]));
        printf("%s\n", diff.empty() ? "Jolly": "Not jolly");
    }
    return 0;
}