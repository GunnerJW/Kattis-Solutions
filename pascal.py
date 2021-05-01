"""
Python 3 solution for the problem Pascal (https://open.kattis.com/problems/pascal)
Execution time: 0.06 s
Submitted on 2020-12-25 21:45:27
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from math import sqrt, ceil, floor

__author__ = 'GunnerJW'

n = int(input())

# counter = 0
# for i in range(n - 1, 0, -1):
#     counter += 1
#     if n % i == 0:
#         break
# print(counter)


ans_found = False
for i in range(2, floor(sqrt(n)) + 1):
    if n % i == 0:
        ans_found = True
        print(n - (n // i))
        break
if not ans_found:
    print(n - 1)

# readln(N);
# counter := 0;
# for i := N - 1 downto 1 do begin
#   counter := counter + 1;
#   if N mod i = 0 then break;
# end;
# writeln(counter);