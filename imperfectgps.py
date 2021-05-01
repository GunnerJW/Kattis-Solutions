"""
Python 3 solution for the problem Imperfect GPS (https://open.kattis.com/problems/imperfectgps)
Execution time: 0.05 s
Submitted on 2020-02-29 12:31:23
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import sqrt
from sys import stdout, stdin
from bisect import bisect_right

n, step = map(int, stdin.readline().split())

x = []
y = []
t = []

for _ in range(n):
    xx, yy, tt = map(int, stdin.readline().split())
    x.append(xx)
    y.append(yy)
    t.append(tt)

xg = []
yg = []
time = 0
while True:
    b = bisect_right(t, time) - 1
    if b == n - 1:
        xg.append(x[-1])
        yg.append(y[-1])
        break
    xv = (time - t[b]) * (x[b + 1] - x[b]) / (t[b + 1] - t[b])
    yv = (time - t[b]) * (y[b + 1] - y[b]) / (t[b + 1] - t[b])
    xg.append(x[b] + xv)
    yg.append(y[b] + yv)
    time += step

d = 0
for i in range(n - 1):
    d += sqrt((x[i] - x[i + 1]) ** 2 + (y[i] - y[i + 1]) ** 2)

dg = 0
for i in range(len(xg) - 1):
    dg += sqrt((xg[i] - xg[i + 1]) ** 2 + (yg[i] - yg[i + 1]) ** 2)

print(abs(100 * (d - dg) / d))
