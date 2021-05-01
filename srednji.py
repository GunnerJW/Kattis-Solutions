"""
Python 3 solution for the problem Srednji (https://open.kattis.com/problems/srednji)
Execution time: 0.11 s
Submitted on 2020-01-05 15:21:00
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from collections import defaultdict
n, median = map(int, input().split())

arr = list(map(int, input().split()))
median_index = arr.index(median)

diff_left = {median_index: 0}
for i in range(median_index - 1, -1, -1):
    x = arr[i]
    if x > median:
        diff_left[i] = diff_left[i + 1] + 1
    else:
        diff_left[i] = diff_left[i + 1] - 1

diff_right = {median_index: 0}
for i in range(median_index + 1, n):
    x = arr[i]
    if x > median:
        diff_right[i] = diff_right[i - 1] - 1
    else:
        diff_right[i] = diff_right[i - 1] + 1

diff_right_rev = defaultdict(list)
for k, v in diff_right.items():
    diff_right_rev[v].append(k)

res = 0

for i in range(median_index, -1, -1):
    x = diff_left[i]
    if x in diff_right_rev:
        res += len(diff_right_rev[x])

print(res)
