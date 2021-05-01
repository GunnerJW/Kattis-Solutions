"""
Python 3 solution for the problem Out of Sorts (https://open.kattis.com/problems/outofsorts)
Execution time: 0.29 s
Submitted on 2020-02-21 22:07:46
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

n, m, a, c, x0 = map(int, input().split())

x = x0

arr = []
arr_dct = {}


def binary_search(v):
    l = 0
    r = n - 1
    while l <= r:
        mid = (l + r) // 2
        if v == arr[mid]:
            return 1
        elif v < arr[mid]:
            r = mid - 1
        else:
            l = mid + 1
    return 0


for i in range(n):
    y = (a * x + c) % m
    arr.append(y)
    x = y

res = sum(binary_search(var) for var in arr)

print(res)
