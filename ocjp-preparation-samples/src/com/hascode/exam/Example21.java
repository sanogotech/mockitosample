package com.hascode.exam;

import java.util.Map;
import java.util.Set;
import java.util.TreeMap;
import java.util.TreeSet;

public class Example21 {
	public static void main(String[] args) {
		Map<SomeObject, SomeObject> map = new TreeMap<SomeObject, SomeObject>();
		Set<SomeObject> set = new TreeSet<SomeObject>();

		for (int i = 0; i < 30; i++) {
			SomeObject obj = new SomeObject(i);
			map.put(obj, obj); // Exception in thread "main"
								// java.lang.ClassCastException:
								// com.hascode.exam.SomeObject cannot be cast to
								// java.lang.Comparable

			set.add(obj); // Exception in thread "main"
							// java.lang.ClassCastException:
							// com.hascode.exam.SomeObject cannot be cast to
							// java.lang.Comparable
		}
	}

}
