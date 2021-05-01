"""
Python 3 solution for the problem Assigning Workstations (https://open.kattis.com/problems/workstations)
Execution time: 1.6 s
Submitted on 2020-01-13 11:38:25
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from heapq import heappop, heappush

researchers, inactivity = map(int, input().split())
arrivals = []
for _ in range(researchers):
    arrival_time, duration = map(int, input().split())
    arrivals.append((arrival_time, duration))

arrivals.sort()
pq = []
res = 0

for researcher in arrivals:
    arrival_time, duration = researcher
    end_time = arrival_time + duration
    while len(pq) != 0 and arrival_time > pq[0][1]:
        heappop(pq)
    if len(pq) == 0:
        heappush(pq, (end_time, end_time + inactivity))
        continue
    x, y = pq[0]
    if x <= arrival_time <= y:
        heappop(pq)
        res += 1
    heappush(pq, (end_time, end_time + inactivity))

print(res)
