"""
Python 3 solution for the problem Jane Eyre (https://open.kattis.com/problems/janeeyre)
Execution time: 0.83 s
Submitted on 2020-12-12 20:40:36
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from sys import stdin
from heapq import heappush, heappop, heapify

__author__ = 'GunnerJW'

n, m, k = map(int, stdin.readline().split())

pq = [('Jane Eyre', k)]
heapify(pq)


for _ in range(n):
    l = stdin.readline()
    parts = l.split('"')
    book_name = parts[1]
    pages = int(parts[-1][1:])
    heappush(pq, (book_name, pages))

upcoming = []
for _ in range(m):
    l = stdin.readline()
    parts = l.split('"')
    time = int(parts[0][:-1])
    book_name = parts[1]
    pages = int(parts[-1][1:])
    upcoming.append((time, book_name, pages))

upcoming = sorted(upcoming, key=lambda tpl: tpl[0])

current_time = 0
upcoming_index = 0

while True:
    while upcoming_index < m and current_time >= upcoming[upcoming_index][0]:
        heappush(pq, upcoming[upcoming_index][1:])
        upcoming_index += 1
    book_name, book_pages = heappop(pq)
    current_time += book_pages
    if book_name == 'Jane Eyre':
        break

print(current_time)