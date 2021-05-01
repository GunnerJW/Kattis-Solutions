"""
Python 3 solution for the problem H to O (https://open.kattis.com/problems/htoo)
Execution time: 0.07 s
Submitted on 2020-12-11 20:32:55
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
"""

from collections import defaultdict

__author__ = 'GunnerJW'

input_molecule, amount = input().split(' ')
target_molecule = input()
amount = int(amount)

lower_bound = ord('A')
upper_bound = ord('Z')


def get_atoms_amount(molecule, multiplicity):
    res = defaultdict(int)

    atom_indices = []
    for i in range(len(molecule)):
        if lower_bound <= ord(molecule[i]) <= upper_bound:
            atom_indices.append(i)

    for i in range(len(atom_indices) - 1):
        current = atom_indices[i]
        next_ = atom_indices[i+1]
        if next_ == current + 1:
            res[molecule[current]] += multiplicity
        else:
            res[molecule[current]] += multiplicity * int(molecule[current + 1:next_])
    last_index = atom_indices[-1]
    if last_index == len(molecule) - 1:
        res[molecule[last_index]] += multiplicity
    else:
        res[molecule[last_index]] += multiplicity * int(molecule[last_index + 1:])

    return res


input_atoms_amount = get_atoms_amount(input_molecule, amount)
target_atoms_amount = get_atoms_amount(target_molecule, 1)

output = 10000000000000
for atom, atom_amount in target_atoms_amount.items():
    if atom not in input_atoms_amount:
        output = 0
        break
    output = min(output, input_atoms_amount[atom] // atom_amount)

print(output)
