"""
Python 3 solution for the problem Managing Packaging (https://open.kattis.com/problems/managingpackaging)
Execution time: 0.23 s
Submitted on 2020-01-25 00:23:00
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from sys import stdin, stdout
from collections import defaultdict
from heapq import heappush, heappop, heapify

first_case = True
while True:
    n = int(stdin.readline())
    if n == 0:
        break
    if not first_case:
        stdout.write('\n\n')
    first_case = False
    graph = defaultdict(set)
    incoming = defaultdict(int)
    for _ in range(n):
        package, *deps = stdin.readline().split()
        for dep in deps:
            graph[dep].add(package)
        incoming[package] += len(deps)
    topo_sort = []
    q = [v for v in incoming if incoming[v] == 0]
    heapify(q)
    while len(q) != 0:
        u = heappop(q)
        topo_sort.append(u)
        for v in graph[u].copy():
            graph[u].remove(v)
            incoming[v] -= 1
            if incoming[v] == 0:
                heappush(q, v)
    if any(len(graph[u]) > 0 for u in graph):
        stdout.write("cannot be ordered")
    else:
        stdout.write('\n'.join(topo_sort))

