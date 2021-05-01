"""
Python 3 solution for the problem Palindromic Password (https://open.kattis.com/problems/palindromicpassword)
Execution time: 0.07 s
Submitted on 2020-02-15 20:12:48
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from bisect import bisect_left
from sys import stdin, stdout


def is_palindrome(x):
    tmp = x // 1000
    d0 = tmp % 10
    d1 = (tmp // 10) % 10
    d2 = (tmp // 100) % 10
    rev = tmp * 1000 + d0 * 100 + d1 * 10 + d2
    return rev == x


def main():
    palindromes = [x for x in range(100000, 1000000) if is_palindrome(x)]
    n = int(stdin.readline())
    for _ in range(n):
        x = int(stdin.readline())
        i = bisect_left(palindromes, x)
        if palindromes[i] == x:
            stdout.write(f'{x}\n')
            continue
        diff = 10_000_000
        min_ = 10_000_000
        if i > 0:
            p = palindromes[i - 1]
            d = abs(x - p)
            if d < diff:
                diff = d
                min_ = p
            elif d == diff:
                if p < min_:
                    min_ = p
        if i < len(palindromes):
            p = palindromes[i]
            d = abs(x - p)
            if d < diff:
                diff = d
                min_ = p
            elif d == diff:
                if p < min_:
                    min_ = p
        stdout.write(f'{min_}\n')
        # print(min_)


main()