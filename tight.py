"""
Python 3 solution for the problem Tight words (https://open.kattis.com/problems/tight)
Execution time: 0.08 s
Submitted on 2020-12-26 10:50:49
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from sys import stdin, stdout
from collections import defaultdict
import sys

__author__ = 'GunnerJW'

sys.setrecursionlimit(100000)


def run(index, previous_letter):
    if index == n:
        return 1
    if memo[index][previous_letter] != -1:
        return memo[index][previous_letter]
    res = run(index + 1, previous_letter)
    if previous_letter + 1 <= k:
        res += run(index + 1, previous_letter + 1)
    if previous_letter - 1 >= 0:
        res += run(index + 1, previous_letter - 1)
    memo[index][previous_letter] = res
    return res


lines = stdin.read().splitlines()

for line in lines:
    k, n = map(int, line.split())
    memo = defaultdict(lambda: defaultdict(lambda: -1))
    ans = 0
    for i in range(k + 1):
        ans += run(1, i)
    for _ in range(n):
        ans /= k + 1
    stdout.write(f'{ans * 100}\n')
