package com.hascode.exam;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class Example10 {
	public static void main(String[] args) {
		Map<String, String> map = new HashMap<String, String>();
		List<String> list = new ArrayList<String>();
		Set<String> set = new HashSet<String>();

		list.add("test"); // works
		set.add("test"); // works, too
		map.add("test", "test"); // does not work
		map.put("test", "foo"); // that is how it works
	}
}
