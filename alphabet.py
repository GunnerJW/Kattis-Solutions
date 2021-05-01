"""
Python 3 solution for the problem Alphabet (https://open.kattis.com/problems/alphabet)
Execution time: 0.05 s
Submitted on 2020-02-21 20:12:38
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

# alphabet

arr = list(input())
n = len(arr)
memo = [-1 for i in range(n)]


def lis(i):
    if memo[i] != -1:
        return memo[i]

    res = 1
    for j in range(i):
        if arr[j] < arr[i]:
            res = max(res, 1 + lis(j))

    memo[i] = res
    return res


mx = 0
for i in range(n):
    mx = max(mx, lis(i))

print(26 - mx)