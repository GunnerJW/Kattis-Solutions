"""
Python 3 solution for the problem Disastrous Downtime (https://open.kattis.com/problems/downtime)
Execution time: 0.45 s
Submitted on 2019-12-14 17:45:51
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

import math


def binary_search(l, r, v, arr):
    while l <= r:
        mid = (l + r) // 2
        if v < arr[mid]:
            r = mid - 1
        elif v > arr[mid]:
            l = mid + 1
        else:
            if mid == (len(arr) - 1):
                return mid
            if arr[mid + 1] != v:
                return mid
            l = mid + 1
    return l


n, k = map(int, input().split())
a = 0
b = 0
res = 1
stamps = [0 for _ in range(n)]
for i in range(n):
    x = int(input())
    if i == 0:
        stamps[0] = x + 1000
        a = 0
        b = 0
        continue
    pos = binary_search(a, b, x, stamps)
    if pos > b:
        a = pos
        b = pos
        stamps[pos] = x + 1000
    elif stamps[pos] != x:
        if (pos - a) > 0:
            a = pos
            b +=1
            stamps[b] = x + 1000
        else:
            b += 1
            stamps[b] = x + 1000
            running = int(math.ceil((b - a + 1) / k))
            res = max(res, running)
    else:
        a = pos + 1
        b += 1
        stamps[b] = x + 1000
print(res)