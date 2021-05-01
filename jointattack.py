"""
Python 3 solution for the problem Joint Attack (https://open.kattis.com/problems/jointattack)
Execution time: 0.03 s
Submitted on 2019-12-06 20:33:33
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from queue import LifoQueue

n = int(input())
stack = LifoQueue()
inp = list(map(int, input().split()))
for x in inp:
    stack.put(x)
up = 1
down = stack.get()
while not stack.empty():
    next_up = down
    next_down = down * stack.get() + up
    up = next_up
    down = next_down
print('{}/{}'.format(down, up))
