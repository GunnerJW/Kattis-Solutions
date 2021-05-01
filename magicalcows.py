"""
Python 3 solution for the problem Magical Cows (https://open.kattis.com/problems/magicalcows)
Execution time: 0.08 s
Submitted on 2020-12-18 19:39:27
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import floor, log2

__author__ = 'GunnerJW'

c, n, m = map(int, input().split())

farms = []

for _ in range(n):
    farms.append(int(input()))

for _ in range(m):
    d = int(input())
    res = 0
    for f in farms:
        n = floor(log2(c) - log2(f))
        if d <= n:
            res += 1
        else:
            res += (1 << (d - n))
    print(res)
