"""
Python 3 solution for the problem Persistent Numbers (https://open.kattis.com/problems/persistent)
Execution time: 0.31 s
Submitted on 2020-12-12 18:31:50
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

__author__ = 'GunnerJW'

single_digit_prime_numbers = [7, 5, 3, 2]
l = len(single_digit_prime_numbers)

n = int(input())

while n != -1:
    if n == 0:
        print(10)
        n = int(input())
        continue
    n2 = n
    d_i = 0
    res = 0
    impossible = False
    while n2 != 1:
        divisor = 9
        while divisor > 1:
            if n2 % divisor == 0:
                n2 //= divisor
                res += divisor * 10 ** d_i
                d_i += 1
                break
            divisor -= 1
        if divisor == 1:
            impossible = True
            break
    if impossible:
        print('There is no such number.')
    else:
        while res <= 10:
            res += 10 ** d_i
            d_i += 1
        print(res)
    n = int(input())
