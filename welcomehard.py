"""
Python 3 solution for the problem Welcome to Code Jam (Hard) (https://open.kattis.com/problems/welcomehard)
Execution time: 0.28 s
Submitted on 2020-02-22 15:10:05
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from collections import defaultdict

MOD = 10000
t = int(input())

s = ''
n = 0
target = 'welcome to code jam'
n_t = len(target)
memo = None


def process(i, i_t):
    if i_t == (n_t - 1):
        return 1
    if i == n:
        return 0
    if memo[i][i_t] != -1:
        return memo[i][i_t]
    res = 0
    for j in range(i + 1, n):
        if s[j] == target[i_t + 1]:
            res = (res + process(j, i_t + 1)) % MOD

    memo[i][i_t] = res
    return res


for case in range(1, t + 1):
    s = input()
    n = len(s)
    memo = defaultdict(lambda: defaultdict(lambda: -1))
    ans = 0
    for ii in range(n):
        if s[ii] == target[0]:
            ans = (ans + process(ii, 0)) % MOD
    print(f'Case #{case}: {ans:04}')
