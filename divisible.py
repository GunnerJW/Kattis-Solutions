"""
Python 3 solution for the problem Divisible Subsequences (https://open.kattis.com/problems/divisible)
Execution time: 0.17 s
Submitted on 2020-02-12 20:24:42
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from collections import defaultdict
from sys import stdin, stdout

t = int(stdin.readline())

for _ in range(t):
    d, n = map(int, stdin.readline().split())
    arr = list(map(int, stdin.readline().split()))
    suffix_sum = [0 for _ in range(n)]
    suffix_sum[n - 1] = arr[n - 1]
    mod_dict = defaultdict(int)
    mod_dict[suffix_sum[n - 1] % d] += 1
    for i in range(n - 2, -1, -1):
        suffix_sum[i] = suffix_sum[i + 1] + arr[i]
        mod_dict[suffix_sum[i] % d] += 1
    res = 0
    for i in range(n):
        sum_ = suffix_sum[i]
        mod = sum_ % d
        if mod == 0:
            res += 1
        mod_dict[mod] -= 1
        res += mod_dict[mod]
    stdout.write(f'{res}\n')

