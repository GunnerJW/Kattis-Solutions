"""
Python 3 solution for the problem Neighborhood Watch (https://open.kattis.com/problems/neighborhoodwatch)
Execution time: 0.24 s
Submitted on 2020-12-25 22:49:22
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

__author__ = 'GunnerJW'

n, k = map(int, input().split())

unsafe = 0

arr = [False for _ in range(n)]

for _ in range(k):
    x = int(input())
    arr[x - 1] = True

i = 0
while i < n:
    if not arr[i]:
        j = i
        while j < n - 1 and not arr[j + 1]:
            j += 1
        # print(f'{i + 1} => {j + 1}')
        unsafe += (j - i + 1) * (j - i + 2) // 2
        i = j + 1
    else:
        i += 1

print(n * (n + 1) // 2 - unsafe)