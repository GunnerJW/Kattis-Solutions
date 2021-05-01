"""
Python 3 solution for the problem Robot Protection (https://open.kattis.com/problems/robotprotection)
Execution time: 0.81 s
Submitted on 2019-12-09 23:07:45
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from functools import reduce


def convex_hull_graham(points):
    '''
    Returns points on convex hull in CCW order according to Graham's scan algorithm. 
    By Tom Switzer <[email protected]>.
    '''
    TURN_LEFT, TURN_RIGHT, TURN_NONE = (1, -1, 0)

    def cmp(a, b):
        return (a > b) - (a < b)

    def turn(p, q, r):
        return cmp((q[0] - p[0]) * (r[1] - p[1]) - (r[0] - p[0]) * (q[1] - p[1]), 0)

    def _keep_left(hull, r):
        while len(hull) > 1 and turn(hull[-2], hull[-1], r) != TURN_LEFT:
            hull.pop()
        if not len(hull) or hull[-1] != r:
            hull.append(r)
        return hull

    points = sorted(points)
    l = reduce(_keep_left, points, [])
    u = reduce(_keep_left, reversed(points), [])
    return l.extend(u[i] for i in range(1, len(u) - 1)) or l


n = int(input())
while n != 0:
    polygon = list()
    for i in range(n):
        polygon.append(tuple(map(int, input().split())))
    convex_hull = convex_hull_graham(polygon)
    area = 0.0
    for i in range(len(convex_hull) - 1):
        p1 = convex_hull[i]
        p2 = convex_hull[i+1]
        area += (p2[0] - p1[0]) * (p2[1] + p1[1]) / 2
    area += (convex_hull[0][0] - convex_hull[-1][0]) * (convex_hull[0][1] + convex_hull[-1][1]) / 2
    print(abs(area))
    n = int(input())
