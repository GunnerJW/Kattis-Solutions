/*
C++ solution for the problem Power Strings (https://open.kattis.com/problems/powerstrings)
Execution time: 0.47 s
Submitted on 2020-01-20 22:37:04
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

#include <iostream>
#include <map>
#include <queue>
#include <cmath>
#include <bitset>
#include <unordered_map>
#include <unordered_set>
#include <algorithm>
#include <cstring>

using namespace std;

typedef unsigned long long ull;
typedef long double ld;
typedef vector<int> vi;
typedef pair<int, int> pii;


int main() {
//    ios::sync_with_stdio(false);
    char arr[2000000];
    scanf("%s", &arr);
    while (arr[0] != '.') {
        int l = strlen(arr);
        vector<bool> excluded(l + 1, false);
        for (int chunk_size = l; chunk_size >= 1; chunk_size--) {
            if (l % chunk_size != 0)
                continue;
            if (excluded[chunk_size])
                continue;
            bool possible = true;
            for (int i = 0; i < chunk_size; i++) {
                int k = i + chunk_size;
                while (k < l) {
                    if (arr[k] != arr[i]) {
                        possible = false;
                        break;
                    }
                    k += chunk_size;
                }
            }
            if (!possible) {
                for (int j = 1; j <= (int) sqrt(chunk_size); j++) {
                    if (chunk_size % j == 0) {
                        excluded[j] = true;
                        excluded[chunk_size / j] = true;
                    }
                }
            }
        }
        for (int i = 1; i <= l; i++) {
            if (!excluded[i] && l % i == 0) {
                printf("%d\n", l / i);
                break;
            }
        }
        scanf("%s", &arr);
    }
    return 0;
}