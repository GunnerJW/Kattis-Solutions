"""
Python 3 solution for the problem Cheating a Boolean Tree (https://open.kattis.com/problems/cheatingbooleantree)
Execution time: 0.12 s
Submitted on 2019-12-17 21:52:19
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

t = int(input())

MAX_CHANGES = 10_001

for case in range(t):
    nodes, target_val = map(int, input().split())
    gates = dict()
    changed = dict()
    values = [{1: MAX_CHANGES, 0: MAX_CHANGES} for i in range(nodes + 1)]
    for i in range(1, nodes + 1):
        if i < (nodes + 1) // 2:
            g, c = map(int, input().split())
            gates[i] = g
            changed[i] = c
        else:
            values[i][int(input())] = 0
    current_node = nodes - 1
    while current_node > 0:
        parent_node = current_node // 2
        sibling_node = current_node + 1
        if gates[parent_node] == 1:
            values[parent_node][1] = min(values[parent_node][1], values[current_node][1] + values[sibling_node][1])
            values[parent_node][0] = min(values[parent_node][0], values[current_node][1] + values[sibling_node][0])
            values[parent_node][0] = min(values[parent_node][0], values[current_node][0] + values[sibling_node][1])
            values[parent_node][0] = min(values[parent_node][0], values[current_node][0] + values[sibling_node][0])
            if changed[parent_node] == 1:
                values[parent_node][1] = min(values[parent_node][1], values[current_node][1] + values[sibling_node][1] + 1)
                values[parent_node][1] = min(values[parent_node][1], values[current_node][1] + values[sibling_node][0] + 1)
                values[parent_node][1] = min(values[parent_node][1], values[current_node][0] + values[sibling_node][1] + 1)
                values[parent_node][0] = min(values[parent_node][0], values[current_node][0] + values[sibling_node][0] + 1)
        else:
            values[parent_node][1] = min(values[parent_node][1], values[current_node][1] + values[sibling_node][1])
            values[parent_node][1] = min(values[parent_node][1], values[current_node][1] + values[sibling_node][0])
            values[parent_node][1] = min(values[parent_node][1], values[current_node][0] + values[sibling_node][1])
            values[parent_node][0] = min(values[parent_node][0], values[current_node][0] + values[sibling_node][0])
            if changed[parent_node] == 1:
                values[parent_node][1] = min(values[parent_node][1], values[current_node][1] + values[sibling_node][1] + 1)
                values[parent_node][0] = min(values[parent_node][0], values[current_node][1] + values[sibling_node][0] + 1)
                values[parent_node][0] = min(values[parent_node][0], values[current_node][0] + values[sibling_node][1] + 1)
                values[parent_node][0] = min(values[parent_node][0], values[current_node][0] + values[sibling_node][0] + 1)
        current_node -= 2
    res = values[1][target_val]
    if res == MAX_CHANGES:
        res = "IMPOSSIBLE"
    print(f"Case #{case + 1}: {res}")


