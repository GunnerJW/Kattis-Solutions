"""
Python 3 solution for the problem Low Order Zeros (https://open.kattis.com/problems/loworderzeros)
Execution time: 0.49 s
Submitted on 2019-12-28 14:38:54
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

MAX = 1_000_000

digits = [0 for i in range(MAX + 1)]

x = 1
for i in range(1, MAX + 1):
    x *= i
    while x % 10 == 0:
        x //= 10
    digits[i] = x % 10
    x %= MAX

n = int(input())
while n != 0:
    print(digits[n])
    n = int(input())