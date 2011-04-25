package com.hascode.exam;

import java.util.HashSet;
import java.util.Set;

public class Example29 {
	public static void main(String[] args) {
		Set<User> users = new HashSet<User>();
		User user1 = new User(1l);
		User user2 = new User(2l);
		User user3 = new User(1l);

		users.add(user1);
		users.add(user2);
		users.add(user3);

		System.out.println(users.size()); // set contains 3 elements

		// if we uncomment the hashCode method the set is going to contain 2
		// elements
	}

	private static class User {
		private Long	userId;
		public User(Long userId) {
			this.userId = userId;
		}

		public Long getUserId() {
			return userId;
		}

		public boolean equals(Object obj) {
			return getUserId().equals(((User) obj).getUserId());
		}

		// public int hashCode() {
		// return 12345;
		// }
	}
}
