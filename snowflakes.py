"""
Python 3 solution for the problem Unique Snowflakes (https://open.kattis.com/problems/snowflakes)
Execution time: 0.38 s
Submitted on 2020-01-26 11:11:51
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from sys import stdin, stdout
# snowflakes
t = int(stdin.readline())

for _ in range(t):
    n = int(stdin.readline())
    flakes = []
    for _ in range(n):
        flakes.append(int(stdin.readline()))
    chosen = dict()
    res = 0
    lower_bound = 0
    for i, x in enumerate(flakes):
        if x in chosen and chosen[x] >= lower_bound:
            res = max(res, i - lower_bound)
            lower_bound = chosen[x] + 1
        chosen[x] = i
    res = max(res, n - lower_bound)
    stdout.write(f'{res}\n')
