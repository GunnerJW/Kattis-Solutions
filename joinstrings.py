"""
Python 3 solution for the problem Join Strings (https://open.kattis.com/problems/joinstrings)
Execution time: 0.23 s
Submitted on 2020-01-02 13:38:28
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

import sys

n = int(sys.stdin.readline())
strings = []

for i in range(n):
    strings.append(sys.stdin.readline().strip())


def get_root_next(e):
    while _root[e] != e:
        _root[e] = _root[_root[e]]
        e = _root[e]
    return e


last = 0
if n > 1:
    _next = [i for i in range(n)]
    _root = [i for i in range(n)]
    prev = [False] * n
    for op in range(n - 1):
        a, b = map(int, sys.stdin.readline().split())
        a = a - 1
        b = b - 1
        root_a = get_root_next(a)
        _root[root_a] = b
        _next[root_a] = b
        prev[b] = True
        last = a

    # for i in range(n):
    #     if not prev[i]:
    #         last = i
    #         break

    while True:
        sys.stdout.write(strings[last])
        if last == _next[last]:
            break
        last = _next[last]
else:
    print(strings[0])
