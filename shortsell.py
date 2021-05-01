"""
Python 3 solution for the problem Short Sell (https://open.kattis.com/problems/shortsell)
Execution time: 0.08 s
Submitted on 2020-12-27 14:30:17
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

__author__ = 'GunnerJW'

n, rate = map(int, input().split())

arr = list(map(int, input().split()))
min_arr = [0 for _ in range(n)]
for i in range(n-1, -1, -1):
    if i == n - 1:
        min_arr[i] = 100 * arr[i] + (i + 1) * rate
    else:
        min_arr[i] = min(min_arr[i + 1], 100 * arr[i] + (i + 1) * rate)

res = 0
for i in range(0, n - 1):
    res = max(res, 100 * arr[i] + rate * i - min_arr[i + 1])

print(res)
