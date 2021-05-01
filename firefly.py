"""
Python 3 solution for the problem Firefly (https://open.kattis.com/problems/firefly)
Execution time: 0.56 s
Submitted on 2020-01-10 20:56:53
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from bisect import bisect_right, bisect_left

n, h = map(int, input().split())

up = []
down = []

for i in range(n):
    x = float(input())
    if i % 2 == 0:
        down.append(x)
    else:
        up.append(x)

up.sort()
down.sort()

min_walls = n + 1
times = 0

for i in range(0, h):
    level = i + 0.5
    down_hit = bisect_left(down, level)
    down_hit = (n // 2) - down_hit
    up_hit = bisect_left(up, h - level)
    up_hit = (n // 2) - up_hit
    x = down_hit + up_hit
    if x < min_walls:
        min_walls = x
        times = 1
    elif x == min_walls:
        times += 1

print(min_walls, times)