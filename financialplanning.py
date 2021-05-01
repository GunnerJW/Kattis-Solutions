"""
Python 3 solution for the problem Financial Planning (https://open.kattis.com/problems/financialplanning)
Execution time: 0.39 s
Submitted on 2020-02-22 20:49:52
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import ceil
from sys import stdin

n, m = map(int, stdin.readline().split())

arr = []

for _ in range(n):
    g, c = map(int, stdin.readline().split())
    arr.append((g / c, g, c))

arr.sort(key=lambda triple: (-triple[0], -triple[1], triple[2]))

g = arr[0][1]
c = arr[0][2]
d = ceil((c + m) / g)

for i in range(1, n):
    g2 = g + arr[i][1]
    c2 = c + arr[i][2]
    d2 = ceil((c2 + m) / g2)
    if d2 > d:
        break
    g = g2
    c = c2
    d = d2

print(d)
