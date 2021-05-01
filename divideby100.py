"""
Python 3 solution for the problem Divide by 100... (https://open.kattis.com/problems/divideby100)
Execution time: 0.31 s
Submitted on 2019-12-22 13:31:27
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

n = input()
m = input()

SIZE = int(1e6) + 1

n_arr = ['0'] * SIZE

for i in range(len(n) - 1, -1, -1):
    n_arr[SIZE - 1 - (len(n) - 1 - i)] = n[i]

last_digit = SIZE - len(n)
comma_index = SIZE - 1 - len(m[1:])

s = set()
trailing_zeroes = SIZE - 1
for i in range(SIZE - 1, comma_index, -1):
    s.add(n_arr[i])
    if s != {'0'}:
        break
    trailing_zeroes -= 1

res = ''
if comma_index < last_digit:
    res = '0.'
    res += ''.join(n_arr[comma_index + 1:trailing_zeroes+1])
else:
    res += ''.join(n_arr[last_digit:comma_index+1])
    res += '.'
    res += ''.join(n_arr[comma_index+1:trailing_zeroes+1])
    if res[-1] == '.':
        res = res[:-1]
print(res)