"""
Python 3 solution for the problem Bazen (https://open.kattis.com/problems/bazen)
Execution time: 0.06 s
Submitted on 2020-12-30 15:46:46
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

__author__ = 'GunnerJW'

A = 125 * 125

x, y = map(float, input().split())


def print_rounded(a, b):
    print(f'{a:0.2f} {b:0.2f}')


if (x, y) == (0, 250):
    print_rounded(125, 0)
elif (x, y) == (250, 0):
    print_rounded(0, 125)
elif (x, y) == (0, 0):
    print_rounded(125, 125)
elif (x, y) == (0, 125):
    print_rounded(250, 0)
elif (x, y) == (125, 0):
    print_rounded(0, 250)
elif (x, y) == (125, 125):
    print_rounded(0, 0)
elif x == 0 and y > 125:
    print_rounded(2 * 125 * 125 / y, 0)
elif x == 0 and y < 125:
    x2 = 2 * (A - (250 * 250 / 2)) / (y - 250)
    y2 = 250 - x2
    print_rounded(x2, y2)
elif x > 125 and y == 0:
    print_rounded(0, 2 * 125 * 125 / x)
elif x < 125 and y == 0:
    y2 = 2 * (A - (250 * 250 / 2)) / (x - 250)
    x2 = 250 - y2
    print_rounded(x2, y2)
elif x > 125:
    y2 = 2 * (A - (250 * 250 / 2)) / x + 250
    print_rounded(0, y2)
else:
    x2 = 2 * (A - (250 * 250 / 2)) / y + 250
    print_rounded(x2, 0)
