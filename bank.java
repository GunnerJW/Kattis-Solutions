/*
Java solution for the problem Bank Queue (https://open.kattis.com/problems/bank)
Execution time: 0.25 s
Submitted on 2017-08-09 15:28:20
Source code extracted automatically by the script https://github.com/GunnerJW/py_utilities/blob/master/kattis_solved_problems_code_extract.py
*/

import java.util.*;


public class Solution {

	public static void main(final String[] args) {
		final Scanner sc = new Scanner(System.in);

		final int n = sc.nextInt();
		final int t = sc.nextInt();

		final List<Person> clients = new ArrayList<Person>();

		for (int i = 0; i < n; i++) {
			clients.add(new Person(sc.nextInt(), sc.nextInt()));
		}

		Collections.sort(clients);

		final int[] toServe = new int[t];
		int left = t;
		int i = 0;

		while (left > 0 && i < clients.size()) {
			final Person client = clients.get(i++);

			if (client.time < t) {
				for (int j = client.time; j >= 0; j--) {
					if (toServe[j] == 0) {
						toServe[j] = client.cash;
						left--;
						break;
					}
				}
			}
		}

		int total = 0;
		for (final int tot : toServe) {
			total += tot;
		}

		System.out.println(total);

		sc.close();
	}

	private static class Person implements Comparable<Person> {
		private final int cash;
		private final int time;

		public Person(final int cash, final int time) {
			this.cash = cash;
			this.time = time;
		}

		@Override
		public int compareTo(final Person o) {
			final int c = o.cash - this.cash;
			if (c != 0) {
				return c;
			}
			return o.time - this.time;
		}

		@Override
		public String toString() {
			return "[" + this.cash + "," + this.time + "]";
		}
	}
}