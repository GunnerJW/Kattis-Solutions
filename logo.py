"""
Python 3 solution for the problem Logo (https://open.kattis.com/problems/logo)
Execution time: 0.09 s
Submitted on 2020-02-28 21:57:30
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import radians, cos, sin, sqrt
from sys import stdout, stdin

cases = int(stdin.readline())

for _ in range(cases):
    n = int(stdin.readline())
    angle = 90
    x = 0
    y = 0
    for _ in range(n):
        cmd, val = stdin.readline().split()
        val = int(val)
        if cmd == 'fd':
            x += cos(radians(angle)) * val
            y += sin(radians(angle)) * val
        elif cmd == 'bk':
            x -= cos(radians(angle)) * val
            y -= sin(radians(angle)) * val
        elif cmd == 'lt':
            angle += val
        elif cmd == 'rt':
            angle -= val
    stdout.write(f'{round(sqrt(x * x + y * y))}\n')
