"""
Python 3 solution for the problem Thanos the Hero (https://open.kattis.com/problems/thanosthehero)
Execution time: 0.07 s
Submitted on 2020-12-26 11:09:57
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

__author__ = 'GunnerJW'

n = int(input())

arr = list(map(int, input().split()))

impossible = False
res = 0

for i in range(n - 1, 0, -1):
    curr = arr[i]
    previous = arr[i - 1]
    if previous >= curr:
        target = curr - 1
        if target < 0:
            impossible = True
            break
        res += previous - target
        arr[i - 1] = target

if impossible:
    print(1)
else:
    print(res)
