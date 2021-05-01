"""
Python 3 solution for the problem Self-Similar Strings (https://open.kattis.com/problems/selfsimilarstrings)
Execution time: 1.06 s
Submitted on 2020-01-24 20:14:56
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from collections import defaultdict

while True:
    try:
        s = input()
        l = len(s)
        degree = 0
        for d in range(l - 1, 0, -1):
            freq = defaultdict(int)
            for i in range(l - d, -1, -1):
                freq[s[i:i + d]] += 1
            self_similar = True
            for deg in freq.values():
                if deg == 1:
                    self_similar = False
                    break
            if self_similar:
                degree = d
                break
        print(degree)
    except EOFError:
        break
