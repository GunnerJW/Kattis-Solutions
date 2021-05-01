"""
Python 3 solution for the problem Sretan (https://open.kattis.com/problems/sretan)
Execution time: 0.05 s
Submitted on 2020-02-21 23:12:41
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import log2


def compute(n):
    res = ''
    while n:
        b = int(log2(n + 1))
        l = (1 << b) - 1
        step = 1 << (b - 1)
        if l <= n < l + step:
            res += '4'
            n -= step
        else:
            res += '7'
            n -= 2 * step

    return res


def main():
    n = int(input())
    print(compute(n))


main()
