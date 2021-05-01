"""
Python 3 solution for the problem Greeting Card (https://open.kattis.com/problems/greetingcard)
Execution time: 0.97 s
Submitted on 2020-02-16 12:31:03
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from bisect import bisect_left
from sys import stdin, stdout

possible_diffs = [(0, 2018), (1118, 1680), (1680, 1118), (2018, 0)]
n = int(stdin.readline())

points = []

for _ in range(n):
    points.append(tuple(map(int, stdin.readline().split())))

points.sort()

res = set()

for idx, p in enumerate(points):
    x, y = p
    for d in possible_diffs:
        dx, dy = d
        target = (x + dx, y + dy)
        i = bisect_left(points, target)
        if i < n and points[i] == target:
            res.add((max(idx, i), min(idx, i)))
        target = (x + dx, y - dy)
        i = bisect_left(points, target)
        if i < n and points[i] == target:
            res.add((max(idx, i), min(idx, i)))

stdout.write(f'{len(res)}')
