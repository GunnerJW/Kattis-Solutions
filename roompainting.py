"""
Python 3 solution for the problem Room Painting (https://open.kattis.com/problems/roompainting)
Execution time: 0.35 s
Submitted on 2020-01-24 20:33:43
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from bisect import bisect_left

n, m = map(int, input().split())
available = []
for _ in range(n):
    available.append(int(input()))
target = []
for _ in range(m):
    target.append(int(input()))
available.sort()
wasted = 0
for t in target:
    wasted += available[bisect_left(available, t)] - t
print(wasted)
