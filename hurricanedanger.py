"""
Python 3 solution for the problem Hurricane Danger! (https://open.kattis.com/problems/hurricanedanger)
Execution time: 0.1 s
Submitted on 2020-03-01 18:49:05
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from sys import stdout, stdin


def norm_squared(vector):
    """
    Computes the square of the norm of vector.

    :type vector: tuple

    :rtype: float
    """
    return vector[0] ** 2 + vector[1] ** 2


def translate(point, vector):
    """
    Translate point p according to vector

    :type point: tuple
    :type vector: tuple
    :rtype: tuple
    """
    return point[0] + vector[0], point[1] + vector[1]


def scale(vector, factor):
    """
    Scale vector by factor

    :type vector: tuple
    :type factor: float
    :rtype:
    """
    return factor * vector[0], factor * vector[1]


def dot_product(u, v):
    """
    Computes the dot product of two vectors u and v.

    :type u: tuple

    :type v: tuple

    :rtype: float
    """
    return u[0] * v[0] + u[1] * v[1]


def project_onto_line(p, a, b):
    """
    Computes the projection of point p onto the line defined by two points a and b. The result is a point c that is
    closest to p than any other point in the said line.
    Note that a and b must be different.

    :type p: tuple
    :type a: tuple
    :type b: tuple
    :rtype: tuple
    """
    ap = p[0] - a[0], p[1] - a[1]
    ab = b[0] - a[0], b[1] - a[1]
    u = dot_product(ap, ab) / norm_squared(ab)
    c = translate(a, scale(ab, u))
    return c


def main():
    EPS = 1e-9
    n = int(stdin.readline())
    for _ in range(n):
        ax, ay, bx, by = map(int, stdin.readline().split())
        a = (ax, ay)
        b = (bx, by)
        m = int(stdin.readline())
        min_ = 1e9
        min_points = []
        for _ in range(m):
            city, x, y = stdin.readline().split()
            x = int(x)
            y = int(y)
            projection = project_onto_line((x, y), a, b)
            dist_sq = (x - projection[0]) ** 2 + (y - projection[1]) ** 2
            if dist_sq - min_ <= -EPS:
                min_ = dist_sq
                min_points = [city]
            elif abs(dist_sq - min_) < EPS:
                min_points.append(city)
        stdout.write(' '.join(min_points) + '\n')


main()
