"""
Python 3 solution for the problem Flood-It (https://open.kattis.com/problems/floodit)
Execution time: 0.6 s
Submitted on 2020-01-05 18:44:25
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from collections import deque
from copy import deepcopy


def set_color(grid, color, connected):
    new_grid = deepcopy(grid)
    for (i, j) in connected:
        new_grid[i][j] = color
    return new_grid


def is_valid(cell, size):
    row, col = cell
    return (0 <= row < size) and (0 <= col < size)


def connected_components(grid):
    size = len(grid)
    visited = set()
    q = deque()
    q.append((0, 0))
    visited.add((0, 0))
    while len(q) != 0:
        row, col = q.pop()
        north, south, west, east = (row - 1, col), (row + 1, col), (row, col - 1), (row, col + 1)
        for (i, j) in [north, south, west, east]:
            if not is_valid((i, j), size):
                continue
            color = grid[i][j]
            if color == grid[row][col] and (i, j) not in visited:
                q.append((i, j))
                visited.add((i, j))
    return visited


def main():
    t = int(input())
    for _ in range(t):
        n = int(input())
        grid = [[] for i in range(n)]
        for i in range(n):
            x = map(int, input())
            for j, c in enumerate(x):
                grid[i].append(c - 1)
        moves = 0
        colors = [0 for _ in range(6)]
        connected = connected_components(grid)
        while len(connected) != n * n:  # We keep going as long as the cells don't have the same color
            # We look for the best color
            max_col = 0
            max_con = set()
            max_grid = set()
            for color in range(6):
                if color == grid[0][0]:
                    continue
                new_grid = set_color(grid, color, connected)
                conn = connected_components(new_grid)
                if len(conn) > len(max_con):
                    max_col = color
                    max_grid = new_grid
                    max_con = conn
            # The best color is found, we pick it
            grid = max_grid
            colors[max_col] += 1
            connected = max_con
            moves += 1
        print(moves)
        print(' '.join(map(str, colors)))


main()
