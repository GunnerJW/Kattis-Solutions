"""
Python 3 solution for the problem FBI Universal Control Numbers (https://open.kattis.com/problems/fbiuniversal)
Execution time: 0.15 s
Submitted on 2020-12-25 20:28:51
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

__author__ = 'GunnerJW'

MAPPING = dict(B=8, G='C', I=1, O=0, Q=0, S=5, U='V', Y='V', Z=2)

BASE = {
    '0': 0, '1': 1, '2': 2, '3': 3, '4': 4, '5': 5, '6': 6, '7': 7, '8': 8, '9': 9, 'A': 10, 'C': 11, 'D': 12,
    'E': 13, 'F': 14, 'H': 15, 'J': 16, 'K': 17, 'L': 18, 'M': 19, 'N': 20, 'P': 21, 'R': 22, 'T': 23, 'V': 24,
    'W': 25, 'X': 26
}


def compute_check_value(text):
    lst = [2, 4, 5, 7, 8, 10, 11, 13]
    ans = 0
    for i in range(8):
        ans += lst[i] * BASE[text[i]]
    return ans % 27


t = int(input())

for _ in range(t):
    test_case, value = input().split()
    test_case = int(test_case)
    value2 = ''
    for i, char in enumerate(value):
        if char in MAPPING and i < 8:
            value2 += str(MAPPING[char])
        else:
            value2 += char
    x = value2[:-1]
    check_letter = BASE[value2[-1]]
    check_value = compute_check_value(x)
    if check_letter != check_value:
        print(f'{test_case} Invalid')
    else:
        res = 0
        for i, char in enumerate(x):
            res += BASE[char] * (27 ** (7 - i))
        print(f'{test_case} {res}')
