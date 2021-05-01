"""
Python 3 solution for the problem Credit Card Payment (https://open.kattis.com/problems/creditcard)
Execution time: 0.35 s
Submitted on 2020-12-27 22:46:37
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import floor

__author__ = 'GunnerJW'


def round_to_nearest_cent(x):
    tmp = x * 100
    tmp_floored = floor(tmp)
    if tmp - tmp_floored >= 0.5:
        return (tmp_floored + 1) / 100
    return tmp_floored / 100


t = int(input())

for _ in range(t):
    r, b, m = map(float, input().split())
    r /= 100
    balance = b
    payments = 0
    while balance > 0 and payments <= 1200:
        monthly_interest = balance * r
        monthly_interest_rounded = round_to_nearest_cent(monthly_interest)
        balance += monthly_interest_rounded
        balance = round_to_nearest_cent(balance)
        balance -= m
        payments += 1
    if payments > 1200:
        print('impossible')
    else:
        print(payments)
