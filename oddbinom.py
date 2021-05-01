"""
Python 3 solution for the problem Odd Binomial Coefficients (https://open.kattis.com/problems/oddbinom)
Execution time: 0.06 s
Submitted on 2020-02-13 21:07:26
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import log2, ceil
from collections import defaultdict

n = int(input())
bits = ceil(log2(n)) + 1

memo = defaultdict(lambda: defaultdict(lambda: defaultdict(lambda: -1)))


def run(i, bits_set, tie):
    if i == bits:
        if not tie:
            return 1 << bits_set
        return 0
    if memo[i][bits_set][tie] != -1:
        return memo[i][bits_set][tie]
    if not tie:
        res = run(i + 1, bits_set + 1, 0) + run(i + 1, bits_set, 0)
    else:
        b = (n & (1 << (bits - 1 - i))) != 0
        if not b:
            res = run(i + 1, bits_set, 1)
        else:
            res = run(i + 1, bits_set + 1, 1) + run(i + 1, bits_set, 0)

    memo[i][bits_set][tie] = res
    return res


ans = run(0, 0, 1)
print(ans)
