"""
Python 3 solution for the problem ICPC Tutorial (https://open.kattis.com/problems/tutorial)
Execution time: 0.05 s
Submitted on 2020-02-07 20:16:42
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

import math

m, n, t = map(int, input().split())

tle = False

if t == 1:
    factorial = 1
    i = 1
    while factorial <= m and i <= n:
        factorial *= i
        i += 1
    tle = factorial > m
elif t == 2:
    tle = n > math.log2(m)
elif t == 3:
    tle = n ** 4 > m
elif t == 4:
    tle = n ** 3 > m
elif t == 5:
    tle = n ** 2 > m
elif t == 6:
    tle = (n * math.log2(n)) > m
elif t == 7:
    tle = n > m

print('TLE' if tle else 'AC')