"""
Python 3 solution for the problem Rounded Buttons (https://open.kattis.com/problems/roundedbuttons)
Execution time: 0.23 s
Submitted on 2020-02-28 21:20:30
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from sys import stdin, stdout

n = int(stdin.readline())

for _ in range(n):
    x, y, w, h, r, m, *pairs = map(float, stdin.readline().split())
    for i in range(0, 2 * int(m), 2):
        xp, yp = pairs[i], pairs[i + 1]
        if xp < x or xp > x + w or yp < y or yp > y + h:
            stdout.write('outside\n')
            continue
        if x <= xp <= x + r:
            if y <= yp <= y + r:
                d = (x + r - xp) ** 2 + (y + r - yp) ** 2
                if d > r ** 2:
                    stdout.write('outside\n')
                    continue
            if y + h - r <= yp <= y + h:
                d = (x + r - xp) ** 2 + (y + h - r - yp) ** 2
                if d > r ** 2:
                    stdout.write('outside\n')
                    continue
        if x + w - r <= xp <= x + w:
            if y <= yp <= y + r:
                d = (x + w - r - xp) ** 2 + (y + r - yp) ** 2
                if d > r ** 2:
                    stdout.write('outside\n')
                    continue
            if y + h - r <= yp <= y + h:
                d = (x + w - r - xp) ** 2 + (y + h - r - yp) ** 2
                if d > r ** 2:
                    stdout.write('outside\n')
                    continue
        stdout.write('inside\n')
    stdout.write('\n')
