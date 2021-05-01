"""
Python 3 solution for the problem Increasing Subsequence (https://open.kattis.com/problems/increasingsubsequence)
Execution time: 0.08 s
Submitted on 2020-01-26 18:36:58
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from sys import stdin, stdout

n = int()
memo = []
arr = []
parent = []


def lis(i):
    if memo[i] != 0:
        return memo[i]

    res = 1
    for j in range(i):
        if arr[j] > arr[i]:
            x = 1 + lis(j)
            if x > res:
                res = x
                parent[i] = j
            elif x == res:
                if arr[j] < arr[parent[i]]:
                    parent[i] = j

    memo[i] = res
    return res


def main():
    global n, arr, memo, parent
    while True:
        n, *arr = map(int, stdin.readline().split())
        arr.reverse()
        if n == 0:
            break
        memo = [0 for _ in range(n)]
        parent = [i for i in range(n)]
        res = 1
        max_i = 0
        for i in range(n):
            x = lis(i)
            if x > res:
                res = x
                max_i = i
            elif x == res:
                if arr[i] < arr[max_i]:
                    max_i = i
        stdout.write(f'{res} ')
        while parent[max_i] != max_i:
            stdout.write(f'{arr[max_i]} ')
            max_i = parent[max_i]
        stdout.write(f'{arr[max_i]}\n')


main()
