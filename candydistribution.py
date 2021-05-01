"""
Python 3 solution for the problem Candy Distribution (https://open.kattis.com/problems/candydistribution)
Execution time: 0.06 s
Submitted on 2020-02-09 11:05:20
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

def extended_gcd(a, b):
    """

    :type a: int
    :type b: int
    :return: A triplet (d, u, v) such that a * u + b * v = d = gcd(a, b)
    :rtype: tuple
    """
    x = 0
    y = 1
    u = 1
    v = 0
    while a != 0:
        q = b // a
        r = b % a
        m = x - u * q
        n = y - v * q
        b = a
        a = r
        x = u
        y = v
        u = m
        v = n
    return b, x, y


for _ in range(int(input())):
    k, c = map(int, input().split())
    gcd, alpha, x = extended_gcd(c, k)
    if gcd != 1:
        print("IMPOSSIBLE")
        continue
    if x == 0:
        alpha += k // gcd
    if alpha > 0:
        print(alpha)
        continue
    u = int(-alpha * gcd / k) + 1
    print(alpha + (u * (k // gcd)))
