"""
Python 3 solution for the problem Kitchen Combinatorics (https://open.kattis.com/problems/kitchencombinatorics)
Execution time: 0.1 s
Submitted on 2020-01-25 13:54:25
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from collections import defaultdict
from math import inf
from itertools import chain
from sys import stdin, stdout

MAX = 1_000_000_000_000_000_000

r, s, m, d, n = map(int, stdin.readline().split())
ings = list(map(int, stdin.readline().split()))
dishes = []
for i in range(s + m + d):
    k, *x = map(int, stdin.readline().split())
    dishes.append(x)

exclusions = defaultdict(set)
for i in range(n):
    a, b = map(int, stdin.readline().split())
    exclusions[min(a, b) - 1].add(max(a, b) - 1)

res = 0
for i in range(s):
    if res == inf:
        break
    for j in range(s, s + m):
        if res == inf:
            break
        if j in exclusions[i]:
            continue
        for k in range(s + m, s + m + d):
            if res == inf:
                break
            if k in exclusions[i] or k in exclusions[j]:
                continue
            combo_res = 1
            ings_used = set()
            for ing in chain(dishes[i], dishes[j], dishes[k]):
                if ing not in ings_used:
                    ings_used.add(ing)
                    combo_res *= ings[ing - 1]
            res += combo_res
            if res > MAX:
                res = inf

stdout.write(str(res) if res != inf else 'too many')
