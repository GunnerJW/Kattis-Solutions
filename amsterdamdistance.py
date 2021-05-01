"""
Python 3 solution for the problem Amsterdam Distance (https://open.kattis.com/problems/amsterdamdistance)
Execution time: 0.06 s
Submitted on 2020-02-29 16:46:15
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import pi

m, n, r = map(float, input().split())

ax, bx, ay, by = map(int, input().split())

res = 1e9
for bxi in range(bx, -1, -1):
    for byj in range(by, -1, -1):
        a = r * abs(bxi - byj) / n
        b = (r / n) * min(bxi, byj) * (pi / m) * abs(ax - ay)
        dist = a + b + (r / n) * (bx - bxi + by - byj)
        res = min(res, dist)

print(res)
