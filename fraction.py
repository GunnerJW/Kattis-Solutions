"""
Python 3 solution for the problem Continued Fraction (https://open.kattis.com/problems/fraction)
Execution time: 0.06 s
Submitted on 2020-12-25 23:31:29
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

__author__ = 'GunnerJW'

n, m = map(int, input().split())

quotients_1 = list(map(int, input().split()))
quotients_2 = list(map(int, input().split()))


def get_p_q(partial_quotients):
    p = 0
    q = 1
    for i in range(len(partial_quotients) - 1, -1, -1):
        x = partial_quotients[i] * q + p
        p = q
        q = x

    return q, p


def get_partial_quotients(numerator, denominator):
    quotients = []
    while True:
        ratio = numerator // denominator
        quotients.append(str(ratio))
        numerator -= denominator * ratio
        if numerator == 0:
            break
        numerator, denominator = denominator, numerator
    return quotients


p1, q1 = get_p_q(quotients_1)
p2, q2 = get_p_q(quotients_2)


a = p1 * q2 + p2 * q1
b = q1 * q2

print(' '.join(get_partial_quotients(a, b)))

a = p1 * q2 - p2 * q1
b = q1 * q2

print(' '.join(get_partial_quotients(a, b)))

a = p1 * p2
b = q1 * q2

print(' '.join(get_partial_quotients(a, b)))

a = p1 * q2
b = q1 * p2

print(' '.join(get_partial_quotients(a, b)))
