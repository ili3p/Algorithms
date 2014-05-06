package my.code;

public class EditDistance {
	private static final int MATCH = 0;
	private static final int INSERT = 1;
	private static final int DELETE = 2;
	private static final int MAXLEN = 25;
//	private Cell[][] m;
	private int [][]m;
	
	public static void main(String[] args) {
		
		String s = "ABCD";
		String t = "DCBA";
		EditDistance ed = new EditDistance();
		System.out.println(ed.stringCompare(s, t));

	}



	EditDistance() {
		m = new int [MAXLEN +1][MAXLEN+1];
	/*	m = new Cell[MAXLEN + 1][MAXLEN + 1]; // DP Table
		for(int i=0; i< MAXLEN+1;++i)
			for(int j=0;j<MAXLEN+1;++j){
				m[i][j] = new Cell();
			}*/
	}
	
	public static class Cell {
		int cost;
		int parent;
	}
	public int stringCompare(String s1, String t1) {

		int i = 1, j = 1, k; // counters
		int[] opt = new int[3]; // cost of the three options
		String s = " " + s1;
		String t = " " + t1;

		for (i = 0; i < MAXLEN; ++i) {
			row_init(i);
			column_init(i);
		}

		for (i = 1; i < s.length(); ++i) {
			for (j = 1; j < t.length(); ++j) {

				opt[MATCH] = m[i - 1][j - 1]
						+ match(s.charAt(i), t.charAt(j));
				opt[INSERT] = m[i][j - 1] + indel(t.charAt(j));
				opt[DELETE] = m[i - 1][j]+ indel(s.charAt(i));

				m[i][j]= opt[MATCH];
//				m[i][j].parent = MATCH;

				for (k = INSERT; k <= DELETE; ++k) {

					if (opt[k] < m[i][j]) {

						m[i][j] = opt[k];
//						m[i][j].parent = k;
					}
				}
			}
		}
		//goal_cell(s, t, i, j);
		i = s.length() - 1;
		j = t.length() - 1;
		return m[i][j];
	}

	private int indel(char charAt) {

		return 1;
	}

	private int match(char charAt, char charAt2) {
		if (charAt == charAt2)
			return 0;
		else
			return 1;
	}

	private void column_init(int i) {
		m[i][0] = i;
	/*	if (i > 0) {
			m[i][0].parent = DELETE;
		} else {
			m[0][i].parent = -1;
		}
	*/}

	private void row_init(int i) {
		m[0][i] = i;
		/*if (i > 0) {
			m[0][i].parent = INSERT;
		} else {
			m[0][i].parent = -1;
		}*/
	}
}
