"""
Python 3 solution for the problem Cakey McCakeFace (https://open.kattis.com/problems/cakeymccakeface)
Execution time: 1.51 s
Submitted on 2020-01-26 22:11:14
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from bisect import bisect_left
from sys import stdin
from collections import defaultdict

en = int(stdin.readline())
ex = int(stdin.readline())

entries = list(map(int, stdin.readline().split()))
exits = list(map(int, stdin.readline().split()))

res = 0
min_time = 0
diffs = defaultdict(list)
for i in range(en):
    entry = entries[i]
    for j in range(bisect_left(exits, entry), ex):
        diffs[i].append(exits[j] - entry)

freqs = defaultdict(int)
for arr in diffs.values():
    for x in arr:
        freqs[x] += 1

for diff, freq in freqs.items():
    if freq > res:
        res = freq
        min_time = diff
    elif freq == res and diff < min_time:
        min_time = diff

print(min_time)
