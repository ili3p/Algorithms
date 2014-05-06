package my.codefu.y11.comminity;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class BrokenCalculator {
	public String operations(int starting, int result) {
		if (result == 0)
			return "-";
		if (result == starting)
			return "";
		if (result == 1) {
			return "/";
		}
		
		Map<Integer, List<Object []>> tree = new HashMap<Integer, List<Object []>>();

		List<Object []> root = new ArrayList<Object []>(1);

		root.add(new Object[] {starting, ""});
		int level = 0;
		tree.put(level, root);
		while (level<1000000) {
			List<Object []> currentNodes = tree.get(level);
			List<Object []> nextNodes = new ArrayList<Object []>();

			for (Object [] node : currentNodes) {
				if ((Integer)(node[0]) < 32000) {
					int mp = (Integer)(node[0])*(Integer)(node[0]);
					if (mp == result) {
						return node[1] + "*";
					} else {
						Object[] next = new Object[] {mp, node[1] + "*"};
						nextNodes.add(next);
					}
				}
				int s =  (Integer)(node[0])+(Integer)(node[0]);
				if (s == result) {
					return node[1] + "+";
				} else {
					 Object[] next = new Object[]{s, node[1] + "+"};
					nextNodes.add(next);
				}

				 Object[] next = new  Object[] {1,node[1] + "/"};
				nextNodes.add(next);
			}
			++level;
			tree.put(level, nextNodes);
		}

		return "";
	}

	public static void main(String[] args) {
		BrokenCalculator s = new BrokenCalculator();
		System.out.println(s.   operations(3, 256)  );
	}
	

//	 class Node {
//		public int value;
//		public String path;
//
//		/**
//		 * @param value
//		 * @param path
//		 */
//		public Node(int value, String path) {
//			super();
//			this.value = value;
//			this.path = path;
//		}
//	}
}

