"""
Python 3 solution for the problem Air Conditioned Minions (https://open.kattis.com/problems/airconditioned)
Execution time: 0.05 s
Submitted on 2020-02-24 23:02:21
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from sys import stdin

n = int(stdin.readline())

intervals = sorted([tuple(map(int, stdin.readline().split())) for _ in range(n)], key=lambda tpl: (tpl[0], tpl[1]))

i = 0
res = 0
while i < n:
    l, r = intervals[i]
    j = i + 1
    while j < n:
        lj, rj = intervals[j]
        if lj > r:
            break
        l = max(l, lj)
        r = min(r, rj)
        j += 1
    res += 1
    i = j

print(res)
