"""
Python 3 solution for the problem Anthony and Cora (https://open.kattis.com/problems/anthony)
Execution time: 0.54 s
Submitted on 2020-12-14 18:13:26
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from collections import defaultdict
import sys

__author__ = 'GunnerJW'

sys.setrecursionlimit(1000002)

n, m = map(int, input().split())

probas = []
for _ in range(n + m - 1):
    probas.append(float(input()))

memo = defaultdict(dict)


def run(w, l):
    if l >= n:
        return 0
    if w == m and l <= n - 1:
        return 1
    if w in memo and l in memo[w]:
        return memo[w][l]
    p = probas[w + l]
    res = p * run(w + 1, l) + (1 - p) * run(w, l + 1)
    memo[w][l] = res
    return res


print(run(0, 0))
